/**
 * @author: wangxu
 * @date: 2021-02-23 13:34
 * 模拟龟兔赛跑
 */
public class ThreadTest5 implements Runnable{

    //胜利者
    private static String winner;

    public static void main(String[] args) {
        ThreadTest5 threadTest5 = new ThreadTest5();
        new Thread(threadTest5, "兔子").start();
        new Thread(threadTest5, "乌龟").start();
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            //判断是否已经有线程跑完100步.如果有本线程也结束
            boolean flag = gameOver(i);
            if(flag){
                break;
            }
            System.out.println(Thread.currentThread().getName() + "--> 跑了" + i + "步");
        }

    }

    //判断是否完成比赛
    private boolean gameOver(int steps){
        if(winner != null){
            return true;
        }else {
            if(steps == 100){
                winner = Thread.currentThread().getName();
                System.out.println("winner" + winner);
                return true;
            }
        }
        return false;
    }
}
