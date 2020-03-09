package datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wangxu
 * @date: 2020/3/9 20:35
 */
public class Queue {
    //队列练习
    //特性先进先出的特性.
    //队列是一种数据结构,就是只允许在开头删除在结尾新增.
    public void queue_01(){
        int[] array = new int[100];
        array[0] = 6;
        array[1] = 3;
        array[2] = 1;
        array[3] = 7;
        array[4] = 5;
        array[5] = 8;
        array[6] = 9;
        array[7] = 2;
        array[8] = 4;
        int head = 0;
        int tail = 9;
        while (head < tail) {
            System.out.print(array[head]);
            head++;
            array[tail] = array[head];
            tail++;
            head++;
        }

    }
}
