package datastructure;

/**
 * @author: wangxu
 * @date: 2020/3/10 20:06
 */
public class Stack {
    //栈(练习)
    /**
     * 判断字符串是否为回文(正反都是一样的)比如:你我你,hah
     * 整理思路就是把数组拆成两份,然后利用栈的后进先出原则比较两份字符串数组,如果一样就是回文
     */
    public void stack(){
        char[] array = {'h', 'k', 'w', 'k', 'o'};
        char[] chars = new char[100];
        int len = array.length;
        //获取数组中点
        int mid = len/2 - 1;
        int top = 0;
        for(int i = 0;i <= mid;i++){
            //先计算i++
            chars[++top] = array[i];
        }
        //获取判断相等的索引
        int next;
        if(len % 2 == 0)
            next = mid + 1;
        else
            next = mid + 2;
        for(int i = next;i < len;i++){
            if(array[i] != chars[top])
                break;
            top--;
        }
        if(top == 0)
            System.out.println("yes");
        else
            System.out.println("no");
    }
}
