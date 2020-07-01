import java.util.List;

/**
 * @author: wangxu
 * @date: 2020/6/17 13:57
 */
public class testa {
    private String name;
    private int age;
    private String compent;
    private List<String> list;

    public testa(String name, int age, String compent) {
        this.name = name;
        this.age = age;
        this.compent = compent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCompent() {
        return compent;
    }

    public void setCompent(String compent) {
        this.compent = compent;
    }

    @Override
    public String toString() {
        return "testa{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", compent='" + compent + '\'' +
                '}';
    }
}
