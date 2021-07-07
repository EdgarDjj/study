package MyThreadPool;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 *
 * @author:edgarding
 * @date:2021/6/22
 **/
public class ThreadPool {
    private int corePoolSize;
    private int maximumPoolSize;
    // 任务缓存队列
    private List<Runnable> taskList = Collections.synchronizedList(new LinkedList<>());
    // 缓存任务数
    private int taskQueueSize;
    // 当前线程数
    private int curWorkerNum;

    public ThreadPool(int corePoolSize, int maximumPoolSize, int taskQueueSize) {
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.taskQueueSize = taskQueueSize;
    }

    public void submit(Task task) {
        if (curWorkerNum > taskQueueSize) {
            System.out.println("任务队列已满");
        } else {
            taskList.add(task);
            taskExec(task);
        }
    }

    public void taskExec(Task task) {
        if (curWorkerNum <= corePoolSize) {
            new Worker("核心线程" + task, taskList).start();
            curWorkerNum++;
        } else if (curWorkerNum > corePoolSize && curWorkerNum < maximumPoolSize) {
            new Worker("非核心线程" + task, taskList).start();
            curWorkerNum++;
        } else {
            System.out.println("任务" + task.toString() + "已经超过缓存");
        }
    }
}
