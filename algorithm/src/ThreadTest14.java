import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangxu
 * @date: 2021-02-23 14:53
 * 线程不安全的集合
 */
public class ThreadTest14 {

    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();

        for(int i = 0;i < 1000;i++){
            new Thread(() -> {
                synchronized (list){
                    //不安全的原因的是如果两个线程同时操作List的同一个位置,数据就会被覆盖掉
                    list.add(Thread.currentThread().getName());
                }

            }).start();


        }
        Thread.sleep(2000);
        System.out.println(list.size());

    }

}
