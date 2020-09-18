import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: wangxu
 * @date: 2020/3/9 20:53
 */
public class run {
    public static void main(String[] args){
        List<TestClass> list = new ArrayList<>();
        list.add(new TestClass("a"));
        list.add(new TestClass("b"));
        list.add(new TestClass("c"));
        list.add(new TestClass("w"));
        list.add(new TestClass("c"));
        list.add(new TestClass("b"));
        System.out.println(list);
        List newList = new ArrayList<>();
        Map<String, List<TestClass>> collect = list.stream().collect(Collectors.groupingBy(TestClass :: getName));
        for (Map.Entry entry : collect.entrySet()) {
            newList.add(entry.getValue());
        }
        System.out.println(newList);
    }
}