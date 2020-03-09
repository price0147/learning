import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.List;

/**
 * @author: wangxu
 * @date: 2020/3/2 19:47
 */
public class Sort {
    public static void main(String[] args) {
        int[] array = {2, 35, 9, 23, 98, 73, 1, 24, 32, 23, 16, 14, 45};
        Sort.quickSort(0,array.length - 1,array);

    }



    //-------------------------------------------------------------------------------
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


    //---------------------------------------------------------------------------------
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
    public static void quickSort(int left, int right,int[] array){
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

        Sort.quickSort(left, i - 1, array);
        Sort.quickSort(i + 1,right, array);
    }
}