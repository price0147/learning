import java.util.Iterator;
import java.util.List;

/**
 * @author: wangxu
 * @date: 2021-01-14 13:54
 */
public class testImpl{

    public void test2(List<TestClass> list) {
        Iterator<TestClass> iterator = list.iterator();
        if (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }

    }
}
