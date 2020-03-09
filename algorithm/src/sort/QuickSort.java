package sort;

import java.util.Arrays;

/**
 * @author: wangxu
 * @date: 2020/3/9 20:23
 */
public class QuickSort {
    /**
     * 快速排序
     * 思想:
     *  填坑大法:
     *      [4,2,5,6,1,3]
     *      把需要排序的第一个元素为坑[4(坑),2,5,6,1,3],并且以这个数为基数,
     *      先从右向左找到比这个基数小的数放到这个坑里,
     *      [3,2,5,6,1,3(坑)],然后在从左往右找到一个比基数打的数放到坑里[3,2(坑),5,6,1,2].
     *      一直循环到这两个数相遇.然后进行递归.
     */
    public void quickSort(int left, int right,int[] array){
        //int[] array = {2, 35, 9, 23, 98, 73, 1, 24, 32, 23, 16, 14, 45};
        int i = left;
        int j = right;
        //这个位置很关键如果把它放在x = array[left]之后当最后一次递归的时候array[left]会出现字符串越界问题.
        if (i > j) {
            return;
        }
        int x = array[left];

        while(i < j){
            //先从右面走找到一个小于基数的值进行填坑.
            while(i < j && array[j] >= x) j--;
            array[i] = array[j];
            System.out.println(Arrays.toString(array));
            while(i < j && array[i] <= x) i++;
            //再从左面走找到一个大于基数的值进行填坑.
            array[j] = array[i];
            System.out.println(Arrays.toString(array));
        }
        array[j] = x;
        System.out.println("end" + Arrays.toString(array));

        this.quickSort(left, i - 1, array);
        this.quickSort(i + 1,right, array);
    }
}
