/**
 * @author: wangxu
 * @date: 2021-02-23 14:53
 * 测试停止线程
 * 1.建议线程正常停止--->利用次数,不建议死循环
 * 2.建议使用标识为--->设置一个标志位
 * 3.不要使用stop或者destroy等过时或者JDK不建议使用的方法
 */
public class ThreadTest7 implements Runnable{

    //1.设置一个标识位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("执行线程 " + i++);
        }
    }

    //2.设置一个公开的方法停止线程,转换标示位
    public void stop(){
        this.flag = false;
    }

    public static void main(String[] args) {
        ThreadTest7 threadTest7 = new ThreadTest7();
        new Thread(threadTest7).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main" + i);
            if(i == 900){
                //调用stop方法切换标示位,让线程停止
                threadTest7.stop();
                System.out.println("线程停止了");
            }
        }
    }
}
