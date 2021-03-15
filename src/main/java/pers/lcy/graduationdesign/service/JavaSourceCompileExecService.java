package pers.lcy.graduationdesign.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pers.lcy.graduationdesign.util.JavaClassExecutor;
import pers.lcy.graduationdesign.util.JavaStringSourceCompile;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaFileObject;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.*;

@Service
public class JavaSourceCompileExecService {
    public static Logger logger= LoggerFactory.getLogger(JavaSourceCompileExecService.class);

    public static int Time_Limited =10;

    public static int Num_Thread=4;

    private static final ExecutorService pool = new ThreadPoolExecutor(Num_Thread, Num_Thread,
            0L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(Num_Thread));

    private static final String WAIT_WARNING = "服务器忙，请稍后提交";
    private static final String NO_OUTPUT = "Nothing.";

    public String execute(String source,String systemIn){
        //诊断器
        DiagnosticCollector<JavaFileObject> compileCollector = new DiagnosticCollector<>();

        byte[] bytesClass= JavaStringSourceCompile.compile(source,compileCollector);
        //编译失败返回诊断信息
        if (bytesClass == null) {
            // 获取编译错误信息
            List<Diagnostic<? extends JavaFileObject>> compileError = compileCollector.getDiagnostics();
            StringBuilder compileErrorRes = new StringBuilder();
            for (Diagnostic diagnostic : compileError) {
                compileErrorRes.append("Compilation error at ");
                compileErrorRes.append(diagnostic.getLineNumber());
                compileErrorRes.append(" "+diagnostic.getMessage(Locale.ENGLISH));
                compileErrorRes.append(".");
                compileErrorRes.append(System.lineSeparator());
            }
            return compileErrorRes.toString();
        }
        //执行源码中的main方法
        Callable<String> runTask = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return JavaClassExecutor.execute(bytesClass, systemIn);
            }
        };

        Future<String> res = null;
        try {
            res = pool.submit(runTask);
        } catch (RejectedExecutionException e) {
            return WAIT_WARNING;
        }

        String runResult;
        try {
            runResult = res.get(Time_Limited, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            runResult = "Program interrupted.";
        } catch (ExecutionException e) {
            runResult = e.getCause().getMessage();
        } catch (TimeoutException e) {
            runResult = "Time Limit Exceeded.";
        } finally {
            res.cancel(true);
        }
        return runResult != null ? runResult : NO_OUTPUT;
    }
}
