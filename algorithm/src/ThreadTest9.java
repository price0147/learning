import java.util.Date;

/**
 * @author: wangxu
 * @date: 2021-02-23 14:53
 * 测试join方法
 */
public class ThreadTest9 implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        ThreadTest9 testJoin = new ThreadTest9();
        Thread thread = new Thread(testJoin);
        thread.start();

        //主线程
        for (int i = 0; i < 1000; i++) {
            if(i ==200){
                thread.join();//插队
            }
            System.out.println("main" + i);
        }
    }


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程vip来了" + i);
        }

    }
}
