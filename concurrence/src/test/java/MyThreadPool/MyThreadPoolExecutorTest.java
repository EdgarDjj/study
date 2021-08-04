package MyThreadPool;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2021/7/30
 **/
public class MyThreadPoolExecutorTest {
    @Test
    public void test() {
        MyThreadPoolExecutor executor = new MyThreadPoolExecutor(3);
        for (int i = 0; i < 10; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程" + Thread.currentThread().getName() + "在工作....");
                }
            });
        }
        executor.shutdown();
    }
}