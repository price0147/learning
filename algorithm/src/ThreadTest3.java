/**
 * @author: wangxu
 * @date: 2021-02-23 11:59
 */
public class ThreadTest3 implements Runnable{
    public static void main(String[] args) {
        //创建一个对象
        ThreadTest3 threadTest3 = new ThreadTest3();
        //创建了一个Thread对象进行代理这个对象
        Thread thread = new Thread(threadTest3);
        //开始线程
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("天道昭昭,我道长存");
        }

    }
}
