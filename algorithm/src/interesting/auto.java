package interesting;

import java.awt.*;
import java.awt.event.InputEvent;

/**
 * @author: wangxu
 * @date: 2020/4/11 18:41
 */
public class auto {

    // 模拟鼠标左键右键
    public static void onclickSB(String lr){
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        if(lr.equals("right")) {
            robot.mousePress(InputEvent.BUTTON3_MASK);
            robot.mouseRelease(InputEvent.BUTTON3_MASK);
        } else {
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
        }
    }

    // 鼠标移动
    public static void change(int type, int x, int y){
        Point p = MouseInfo.getPointerInfo().getLocation();
        int width = (int) p.getX() + x;
        int heigh = (int) p.getY() + y;
        if(type == 0) {
            width = x;
            heigh = y;
        }
        Robot robot;
        try {
            robot = new Robot();
            robot.mouseMove(width,heigh);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    // 进程暂停
    public static void stop(int s){
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Point p  = MouseInfo.getPointerInfo().getLocation();
        System.out.println(p.getX() + "---" +p.getY());
        auto.change(0,471,15);
    }

}
