import datastructure.LinkedList;
import datastructure.Queue;
import datastructure.Stack;
import interesting.MessageBoom;

import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * @author: wangxu
 * @date: 2020/3/9 20:53
 */
public class run {
    public static void main(String[] args) throws AWTException {
        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for (int a : list) {
            a = 2;
        }
        System.out.println(list);
    }
}
