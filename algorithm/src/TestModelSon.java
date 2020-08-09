/**
 * @author: wangxu
 * @date: 2020/8/3 16:56
 */
public class TestModelSon extends TestModel{
    String Value;

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    @Override
    public String toString() {
        return "TestModelSon{" +
                "Value='" + Value + '\'' +
                '}';
    }
}
