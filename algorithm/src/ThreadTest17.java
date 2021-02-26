import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: wangxu
 * @date: 2021-02-23 14:53
 * 测试线程池
 */
public class ThreadTest17 {

    public static void main(String[] args) throws InterruptedException {
        //1.创建服务,创建线程池
        //ExecutorService executorService = Executors.newFixedThreadPool(10);
        //创建线程池
        ExecutorService executorService = new ThreadPoolExecutor(4,4,1000, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());
        executorService.execute(new MyThread());

        //2.关闭连接
        executorService.shutdownNow();


    }


}
class MyThread implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
