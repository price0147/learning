import java.util.concurrent.*;

/**
 * @author: wangxu
 * @date: 2021-02-23 13:48
 * callable的好处
 * 1.可以定义返回值
 * 2.可以抛出异常
 */
public class ThreadTest6 implements Callable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadTest6 threadTest1 = new ThreadTest6();
        ThreadTest6 threadTest2 = new ThreadTest6();
        ThreadTest6 threadTest3 = new ThreadTest6();

        //创建线程池
        ExecutorService executorService = new ThreadPoolExecutor(3,3,1000, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>(),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        //提交执行
        Future submit1 = executorService.submit(threadTest1);
        Future submit2 = executorService.submit(threadTest2);
        Future submit3 = executorService.submit(threadTest3);

        //获取结果
        boolean r1 = (boolean) submit1.get();
        boolean r2 = (boolean) submit2.get();
        boolean r3 = (boolean) submit3.get();
        System.out.println(r1 + "r1" + "," + r2 + "r2" + "," + r3 + "r3");

        //关闭服务
        executorService.shutdownNow();
    }

    @Override
    public Object call() throws Exception {
        System.out.println("我是异步线程");
        return true;
    }
}
