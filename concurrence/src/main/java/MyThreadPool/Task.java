package MyThreadPool;

/**
 * Description:
 * 具体任务
 *
 * @author:edgarding
 * @date:2021/6/22
 **/
public class Task implements Runnable {
    private int id;

    public Task(int id) {
        this.id = id;
    }


    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + "正在执行: " + id);
        System.out.println(name + "完成执行：" + id);
    }
}
