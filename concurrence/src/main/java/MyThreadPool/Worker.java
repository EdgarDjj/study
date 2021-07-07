package MyThreadPool;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * 线程
 * 线程名 工作队列
 *
 * @author:edgarding
 * @date:2021/6/22
 **/
public class Worker extends Thread {
    String name;
    List<Runnable> list;

    public Worker(String name, List<Runnable> list) {
        this.name = name;
        this.list = list;
    }

    @Override
    public void run() {
        System.out.println("Worker: " + name + "正在执行");
        while (list.size() > 0) {
            Runnable task = list.remove(0);
            task.run();
        }
    }
}
