/**
 * @author: wangxu
 * @date: 2021-02-23 14:53
 * 观察状态
 */
public class ThreadTest10{

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for(int i = 0;i < 5;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {


                }
            }
            System.out.println("我要结束了");
        });

        //观察状态
        Thread.State state = thread.getState();
        System.out.println(state);

        //观察启动后
        thread.start();//启动线程
        state = thread.getState();
        System.out.println(state);

        //只要线程不终止,我们就一直输出状态
        while(state != Thread.State.TERMINATED){
            Thread.sleep(100);
            state = thread.getState();//更新线程状态
            System.out.println(state);
        }
    }

}
