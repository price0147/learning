/**
 * @author: wangxu
 * @date: 2021-02-23 11:17
 * 1. 继承Thread类,重写Run方法,调用start开启线程
 * 总结:线程开启不一定执行,由CPU执行
 */
public class ThreadTest extends Thread{

    public static void main(String[] args) {
        //创建一个现存对象
        ThreadTest threadTest = new ThreadTest();
        //开启线程,这个位置也可以用run方法.run方法就表示普通的执行run方法
        threadTest.start();
        for(int i = 0;i < 2000;i++){
            System.out.println("我是主线程");
        }
    }

    @Override
    public void run() {
        for(int i = 0;i < 20;i++){
            System.out.println("我是分支线程");
        }
    }
}
