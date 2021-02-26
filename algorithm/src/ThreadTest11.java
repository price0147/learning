/**
 * @author: wangxu
 * @date: 2021-02-23 14:53
 * 测试线程优先级
 */
public class ThreadTest11 {

    public static void main(String[] args) throws InterruptedException {
        //主线程默认优先级
        System.out.println(Thread.currentThread().getName() + "--->"+Thread.currentThread().getPriority());
        MyPriority myPriority = new MyPriority();
        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);
        Thread t5 = new Thread(myPriority);
        Thread t6 = new Thread(myPriority);

        //设置优先级,在启动线程
        t1.start();

        t2.setPriority(1);
        t2.start();

        t3.setPriority(4);
        t3.start();

        t4.setPriority(Thread.MAX_PRIORITY);
        t4.start();
    }

}

class MyPriority implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--->"+Thread.currentThread().getPriority());
    }
}
