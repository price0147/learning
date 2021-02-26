import sun.security.krb5.internal.Ticket;

/**
 * @author: wangxu
 * @date: 2021-02-23 13:22
 * 多线程同时操作同一个对象
 * 买火车票的例子
 */
//发现多个线程操作同一个资源时会出现问题
public class ThreadTest4 implements Runnable{
    private int ticketNums = 10;

    public static void main(String[] args) {
        ThreadTest4 threadTest4 = new ThreadTest4();
        new Thread(threadTest4,"小明").start();
        new Thread(threadTest4,"老师").start();
        new Thread(threadTest4,"黄牛").start();
    }



    @Override
    public void run() {
        while(true){
            if(ticketNums <= 0){
                break;
            }
            //线程延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketNums-- + "张票");
        }
    }
}
