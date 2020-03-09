package sort;

import java.util.Arrays;

/**
 * @author: wangxu
 * @date: 2020/3/9 20:23
 */
public class BubbleSort {
    //冒泡排序
    /**
     * 思路说明:
     * 第一个数和前一个数进行比较如果大于就换位置,
     * 这样每一次比较都会把最大的放到最后面,
     * 下一轮循环也是一样,再把第二大的放到倒数第二位.
     */
    public void bubbleSort(){

        int array[] = {2, 35, 9, 23, 98, 73, 1, -2, 24, 32, 23, -7, 16, 14, 45};
        //这里做的是控制循环次数
        for (int x = 0; x < array.length - 1; x++) {
            //这里才是控制循环比较,并且换值.
            for (int y = 0; y < array.length - x - 1; y++) {
                if (array[y] > array[y + 1]) {
                    array[y + 1] = array[y + 1] + array[y];
                    array[y] = array[y + 1] - array[y];
                    array[y + 1] = array[y + 1] - array[y];
                }
            }
            System.out.println(Arrays.toString(array));
        }

        System.out.println("end" + Arrays.toString(array));

        //这个暂时还不知道是什么排序,
        /**
         * 思路:用一个数挨个去比较,如果比这个数大,就用换这个数继续比较,最后进行排序
         */
       /* for(int x = 0;x < array.length - 1;x++){
            for (int y = x + 1;y < array.length; y++) {
                if (array[x] > array[y]) {
                    array[x] = array[x] + array[y];
                    array[y] = array[x] - array[y];
                    array[x] = array[x] - array[y];
                }
            }
            System.out.println(Arrays.toString(array));
        }
        System.out.println("end" + Arrays.toString(array));*/
    }
}
