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
        ArrayList<testa> list = new ArrayList();
        list.add(new testa("wangx", 2, "大砍刀"));
        list.add(new testa("wangxx", 3, "小砍刀"));
        list.add(new testa("wangxxx", 4, "俩大招"));

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("ka");
        list1.add("kaa");
        list1.add("kaaa");

        for (String k : list1) {

        }

        for (testa test : list) {
            test.setAge(9527);
        }
        System.out.println(list);
    }
}
