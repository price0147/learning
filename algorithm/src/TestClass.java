import java.io.Serializable;
import java.util.Comparator;

/**
 * @author: wangxu
 * @date: 2020/9/16 15:10
 */
public class TestClass implements Serializable {
    //普通代码块
    {
        System.out.println("普通代码块");
    }
    static{
        System.out.println("静态代码块");
    }
    private String name;
    private Integer age;
    private Integer sex;
    public TestClass(){}
    public TestClass(String name,Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "name='" + name + '\'' +
                "age='" + age + '\'' +
                '}';
    }
}
