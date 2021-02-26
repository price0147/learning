/**
 * @author: wangxu
 * @date: 2021-01-14 14:03
 */
public abstract class abClass {
    String in;

    public abClass(){
        in = "我是抽象类变量";
        System.out.println("我是抽象类构造方法");
    }

    public int test(){
        System.out.println(in);
        System.out.println("问题1");
        test2();
        return 2;
    }
    public abstract String test2();
}
