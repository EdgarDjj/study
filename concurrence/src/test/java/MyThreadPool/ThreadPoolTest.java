package MyThreadPool;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2021/6/22
 **/
public class ThreadPoolTest {

    @Test
    public void testThreadPoolJobs() {
        ThreadPool threadPool = new ThreadPool(5, 10, 20);
        for (int i = 0; i < 15; i++) {
            Task task = new Task(i);
            threadPool.submit(task);
        }
    }
}