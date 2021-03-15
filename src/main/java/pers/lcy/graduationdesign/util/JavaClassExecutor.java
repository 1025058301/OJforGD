package pers.lcy.graduationdesign.util;

import pers.lcy.graduationdesign.util.HackClass.HackInputStream;
import pers.lcy.graduationdesign.util.HackClass.HackSystem;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JavaClassExecutor {
    public static String execute(byte[] classByte,String systemIn){
        ClassModifier classModifier=new ClassModifier(classByte);
        //替换System类和Scanner类为自己的类
        byte[] modifyBytes=classModifier.modifyUTF8Constant(
                "java/lang/System","pers/lcy/graduationdesign/util/HackClass/HackSystem");
        modifyBytes=classModifier.modifyUTF8Constant(
                "java/util/Scanner","pers/lcy/graduationdesign/util/HackClass/HackScanner");
        //设置用户输入
        ((HackInputStream)(HackSystem.in)).set(systemIn);
        //加载字节码数组，得到JVM可用的类型
        HotSwapClassLoader classLoader=new HotSwapClassLoader();
        Class clazz=classLoader.loadByte(modifyBytes);
        //使用反射调用源代码中的main方法
        try {
            Method mainMethod = clazz.getMethod("main", new Class[] { String[].class });
            mainMethod.invoke(null, new String[] { null });
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            /*
            被调用的方法的内部抛出了异常而没有被捕获时，将由此异常接收，
            由于这部分异常是远程执行代码的异常，我们要把异常栈反馈给客户端，
            所以不能使用默认的无参 printStackTrace() 把信息 print 到 System.err 中，
            而是要把异常信息 print 到 HackSystem.err 以反馈给客户端
            */
            e.getCause().printStackTrace(HackSystem.err);
        }

        String res = HackSystem.getBufferString();
        HackSystem.closeBuffer();
        return res;
    }
}
