package datastructure;

/**
 * @author: wangxu
 * @date: 2020/3/9 20:33
 */
public class LinkedList {
    //链表学习(模拟数组链表)

    /**
     * 原版链表:原版链表是用C/C++指针写的.利用结构体,存储指针和数值.
     *
     * 数据模拟链表版
     * 思路:right数据就等于是有顺序的了,right[1]的数值表示一号位的下一个位置在data数组里的索引,就是说下一位是data[right[1]]
     * date{5,2,4,6,2,7,3,-1,-1}
     * right{4,6,2,0,3,5,-1,-1,-1}
     */
    public void linkedList(){
        int[] date = {-1,2,3,5,8,9,10,18,26,32,-1,-1,-1};
        int[] right = {-1,2,3,4,5,6,7,8,9,0,-1,-1,-1};
        //表示date有9个数
        int len = 9;
        for(int i = 1;i <= len;i++){
            if(i != len){
                right[i] = i+1;
            }else{
                right[i] = 0;
            }
        }
        int newNuber = 6;
        date[++len] = newNuber;

        int t = 1;
        while(t != 0){
            if (date[right[t]] > date[len]) {
                right[len] = right[t];
                right[t] = len;
                break;
            }
            t = right[t];
        }
        t = 1;
        while(t != 0){
            System.out.println(date[t]);
            t = right[t];
        }
    }
}
