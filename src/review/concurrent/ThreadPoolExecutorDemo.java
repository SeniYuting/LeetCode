package review.concurrent;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {

    static int consumeTaskSleepTime = 5;

    public static void main(String[] args) {
        //构造一个线程池，阻塞队列小，会有部分任务丢失
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 4, 200,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(5),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        // 其中：ThreadPoolExecutor.DiscardOldestPolicy()是任务拒绝策略：丢弃队列最前面的任务，然后重新尝试执行任务
        for (int i = 1; i <= 20; i++) { //定义最大添加20个线程到线程池中
            try {
                //一个任务，并将其加入到线程池
                String work = "work@ " + i;
                System.out.println("put ：" + work);
                threadPool.execute(new ThreadPoolTask(work));
                //便于观察，等待一段时间
                Thread.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 线程池执行的任务
     */
    public static class ThreadPoolTask implements Runnable, Serializable {
        private static final long serialVersionUID = 0;
        //保存任务所需要的数据
        private Object threadPoolTaskData;

        ThreadPoolTask(Object works) {
            this.threadPoolTaskData = works;
        }

        public void run() {
            //处理一个任务
            System.out.println("start------" + threadPoolTaskData);
            try {
                //便于观察，等待一段时间
                Thread.sleep(consumeTaskSleepTime);
            } catch (Exception e) {
                e.printStackTrace();
            }
            threadPoolTaskData = null;
        }
    }
}