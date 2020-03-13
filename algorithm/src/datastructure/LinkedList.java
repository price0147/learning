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
     * 思路:其实right数组里的元素,就是指针链表(指针实现的链表->[data,指针]->[data,指针])里面的指针,
     *      这个指针不光指向下一个data其实也指向下一个结构体里的指针(结构体->[data,指针]),所以最后遍历
     *      都会用t来获取下一个节点的指针和数值.
     * date{5,2,4,6,2,7,3,-1,-1}
     * right{4,6,2,0,3,5,-1,-1,-1}
     */
    public void linkedList(){
        int[] date = {-1,2,3,5,8,9,10,18,26,32,-1,-1,-1};
        int[] right = {-1,2,3,4,5,6,7,8,9,0,-1,-1,-1};
        //表示date有9个数
        int len = 9;
        //这里是初试right数组
        for(int i = 1;i <= len;i++){
            if(i != len){
                right[i] = i+1;
            }else{
                right[i] = 0;
            }
        }
        int newNuber = 6;
        //这个是直接把新增需要插入的元素直接放到data尾部.
        date[++len] = newNuber;

        int t = 1;
        //精髓从这里开始,这里面找到需要插入的位置,将需要插入的数据在data里面的坐标或者说是索引(坐标->data[坐标])),存到对应元素位置上去,
        //然后再把被替换掉的right里的元素放到,换到替换者数值的对应索引上
        // (因为right里面的值不光指向data里的数值,同时也指向right数组里的下一个"指针")--如果复看是不理解可以去看类的头部搞懂整体思路.
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
            //这个位置就是上面说到的t就是结构体里的指针,他指向下一个节点的数值,也指向下一个节点的指针.
            System.out.println(date[t]);
            t = right[t];
        }
    }
}
