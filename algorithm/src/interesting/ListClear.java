package interesting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author: wangxu
 * @date: 2020/4/11 18:41
 */
public class ListClear {

    public static void main(String[] args) {
        listTest();
    }

    /**
     * 如果将list一遍循环一遍删除
     */
    public static void listTest() {

        //这样获取到的list其实放回的并不是真正ArrayList,只不过是Arrays这个类继承AbstractList，但是并没有Override抽象类中关于新增、删除的方法，因此才会抛出UnsupportedOperationException异常。
        //List<String> arrayList = Arrays.asList(new String[]{"豆逼","老年人","电竞选手"}); 这种写法不支持新增,修改,和删除操作

        List<String> arrayList = new ArrayList<>();
        arrayList.add("逗逼");
        arrayList.add("老年人");
        arrayList.add("电竞选手");

        //使用迭代器,解决问题
        /*Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.equals("老年人")) {
                iterator.remove();
            }
        }*/


        //正序的方法
        /*for(int i = 0;i < arrayList.size();i++){
            if (arrayList.get(i).equals("老年人")) {
                arrayList.remove(i);
                i -= 1;
            }
        }*/

        //倒序循环
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (arrayList.get(i).equals("老年人")) {
                arrayList.remove(i);
            }
        }
        System.out.println(arrayList);
    }
}
