import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: wangxu
 * @date: 2021-02-23 14:53
 * Lock锁
 */
public class ThreadTest13 {

    public static void main(String[] args) throws InterruptedException {
        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket,"我").start();
        new Thread(buyTicket,"你").start();
        new Thread(buyTicket,"黄牛").start();
    }

}

class BuyTicket implements Runnable{
    //票
    private int tickeNums = 10;
    //定义一个Lock锁
    private final ReentrantLock lock = new ReentrantLock();

    boolean flag = true;//外部停止方式

    @Override
    public void run() {
        while(flag){
            buy();
        }

    }

    //方法锁,锁的是This
    private void buy(){
        //加锁
        lock.lock();
        try {
            //判断是否有票
            if(tickeNums <= 0){
                flag = false;
                return ;
            }
            //模拟延时
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //解锁
            lock.unlock();
        }

        //买票
        System.out.println(Thread.currentThread().getName() + "拿到" + tickeNums--);
    }
}
