package interesting;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
/**
 * @author: wangxu
 * @date: 2020/3/13 14:04
 */
public class MessageBoom {
    public void run() throws AWTException {
        String sentence = "从前有座山,山里有座庙,庙里有个老和尚和小和尚,和尚对小和尚说：";// 定义要发送的话
        Robot robot = new Robot();// 创建Robot对象
        robot.delay(3000);// 延迟三秒，主要是为了预留出打开窗口的时间，括号内的单位为毫秒
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        String[] authors = sentence.split("[,]");// 字符串根据,分割
        for (int j = 0; j < 50; j++) {//循环次数
            for (int i = 0; i < authors.length; i++) {
                String sentencet = authors[i];
                Transferable tText = new StringSelection(sentencet);
                clip.setContents(tText, null);
                // for (int j = 1; j <= 1; j++) {
                // 以下两行按下了ctrl+v，完成粘贴功能
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);

                robot.keyRelease(KeyEvent.VK_CONTROL);// 释放ctrl按键，像ctrl，退格键，删除键这样的功能性按键，在按下后一定要释放，不然会出问题。crtl如果按住没有释放，在按其他字母按键是，敲出来的回事ctrl的快捷键。
                robot.delay(500);// 发送间隔
                robot.keyPress(KeyEvent.VK_ENTER);// 回车
                // }
            }
        }
    }
}
