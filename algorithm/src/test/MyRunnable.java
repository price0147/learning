package test;

/**
 * @author: wangxu
 * @date: 2020-12-22 16:09
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for(int i=0;i < 1000;i++){
            System.out.println(i);
        }
    }
}
