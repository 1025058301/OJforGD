package pers.lcy.graduationdesign.util;

import javax.tools.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaStringSourceCompile {
    private static Map<String,JavaFileObject> fileObjectMap=new ConcurrentHashMap<>();

    // \\s匹配任意空白字符
    private static Pattern CLASS_PATTERN = Pattern.compile("class\\s+([$_a-zA-Z][$_a-zA-Z0-9]*)\\s*");

    /**
     * 用于将java源代码编译成字节码保存在字节数组中返回
     * @param source 源代码
     * @return
     */
    public static byte[] compile(String source,DiagnosticCollector<JavaFileObject> diagnosticCollector){
        JavaCompiler javaCompiler=ToolProvider.getSystemJavaCompiler();
        //获取诊断信息监视器
        JavaFileManager javaFileManager=
                new MyJavaFileManager(javaCompiler.getStandardFileManager(diagnosticCollector,null,null));
        //通过正则表达式匹配获取类名
        Matcher matcher= CLASS_PATTERN.matcher(source);
        String classname;
        if(matcher.find()){
            classname=matcher.group(1);
        }else {
            throw new IllegalArgumentException("NO valid class");
        }

        //将源码字符串构造为JavaFileObject，供编译使用
        JavaFileObject sourceJavaFileObject=new MyJavaFileObject(classname,source);
        Boolean result= javaCompiler.getTask(null,javaFileManager,diagnosticCollector,
                null,null, Arrays.asList(sourceJavaFileObject)).call();
        JavaFileObject bytesJavaFileObject=fileObjectMap.get(classname);
        if (result && bytesJavaFileObject != null) {
            return ((MyJavaFileObject) bytesJavaFileObject).getCompiledBytes();
        }
        return null;
    }

    public static class MyJavaFileObject extends SimpleJavaFileObject {
        private String source;
        private ByteArrayOutputStream byteArrayOutputStream;

        /**
         * 构造用于存放源代码的对象
         * @param name
         * @param source
         */
        public MyJavaFileObject(String name,String source){
            super(URI.create("String:///" + name + Kind.SOURCE.extension),Kind.SOURCE);
            this.source=source;
        }

        /**
         * 构造用于存放字节码的对象
         * @param name
         * @param kind
         */
        public MyJavaFileObject(String name,Kind kind){
            super(URI.create("String:///" + name + Kind.SOURCE.extension),kind);
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
            if(source==null){
                throw  new IllegalArgumentException("源代码为空");
            }
            return source;
        }

        @Override
        public OutputStream openOutputStream() throws IOException {
            byteArrayOutputStream=new ByteArrayOutputStream();
            return byteArrayOutputStream;
        }

        public byte[] getCompiledBytes(){
            return byteArrayOutputStream.toByteArray();
        }
    }

    public static class MyJavaFileManager extends ForwardingJavaFileManager<JavaFileManager> {
        public MyJavaFileManager(JavaFileManager javaFileManager) {
            super(javaFileManager);
            fileObjectMap=fileObjectMap;
        }

        /**
         * 这个方法的作用是从指定位置读取Java程序并生成JavaFIleObject对象供编译器使用
         */
        @Override
        public JavaFileObject getJavaFileForInput(Location location, String className, JavaFileObject.Kind kind) throws IOException {
            JavaFileObject javaFileObject = fileObjectMap.get(className);
            if (javaFileObject == null) {
                return super.getJavaFileForInput(location, className, kind);
            }
            return javaFileObject;
        }

        @Override
        public JavaFileObject getJavaFileForOutput(Location location, String className, JavaFileObject.Kind kind,FileObject sibling) throws IOException {
            JavaFileObject javaFileObject = new MyJavaFileObject(className, kind);
            fileObjectMap.put(className, javaFileObject);
            return javaFileObject;
        }
    }
}
