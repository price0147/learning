/**
 * @author: wangxu
 * @date: 2021-02-23 14:53
 * 定义lock锁
 */
public class ThreadTest12 {
    public static void main(String[] arg){
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true);//默认是false表示是用户线程,正常的线程都是用户线程...
        thread.start();
        //因为虚拟机不用等待守护线程运行完毕,只要用户线程都结束,凶自动结束
        Thread thread1 = new Thread(you);
        thread1.start();

    }
}

class God implements Runnable{
    @Override
    public void run(){
        while(true){
            System.out.println("旭哥护着你");
        }
    }
}

class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("一天开开心心的活着");
        }
        System.out.println("game over");
    }
}
