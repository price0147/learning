import java.util.Date;

/**
 * @author: wangxu
 * @date: 2021-02-23 14:53
 * 模拟倒计时
 */
public class ThreadTest8 {

    public static void main(String[] args) throws InterruptedException {
        ThreadTest8 threadTest8 = new ThreadTest8();
        //模拟当前时间
        threadTest8.outTime();
        //打印倒计时
        //threadTest8.tenDown();
    }

    public void tenDown(){
        int num = 10;

        while(true){
            try {
                Thread.sleep(1000);
                System.out.println(num--);
                if(num <= 0){
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void outTime() throws InterruptedException {
        while(true){
            Thread.sleep(1000);
            System.out.println(new Date().toString());
        }
    }
}
