/**
 * @author: wangxu
 * @date: 2021-02-23 14:53
 * 测试生产消费者问题:信号灯放,通过标志位
 */
public class ThreadTest16 {

    public static void main(String[] args) throws InterruptedException {
        TV tv = new TV();
        new Player(tv).start();
        new Watcher(tv).start();

    }

}

//生产者 --> 演员
class Player extends Thread{
    TV tv;

    public Player(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                tv.play("跳大神");
            }else{
                tv.play("放广告");
            }

        }

    }
}

//消费者 --> 观众
class Watcher extends Thread{
    TV tv;

    public Watcher(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}

//产品 --> 节目
class TV {
    //演员表演,观众等待
    //观众观看,演员等待
    String voice; //表演节目
    boolean flag = true;

    //表演
    public synchronized void play(String voice) {
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员表演了: " + voice);
        //通知观众观看
        this.notifyAll();//通知唤醒
        this.voice = voice;
        this.flag = !this.flag;
    }

    public synchronized void watch(){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观看了: " + voice);
        this.notifyAll();
        this.flag = !this.flag;
    }
}