import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

/**
 * @author: wangxu
 * @date: 2020/6/17 13:57
 */
public class testa {
    String name = "wangx";
    {
        System.out.println("我是一个初始化块,在调用任何构造器之前都必须先执行我");
        System.out.println("我是来证明name值已经被初试化了的:");
    }
    static {
        System.out.println("我是静态代码块");
    }
    public void test(){
        TestModel testModel = new TestModel();
        testModel.setName("wangx");
        Map<String, TestModel> map = new HashMap<>();
        map.put("k",testModel);
        TestModel testModel1 = map.get("k");
        testModel1.setName("wangxx");
        System.out.println("这个是map里的对象:" + testModel1);
        System.out.println("这个是外头的对象:" + testModel);
        System.out.println("这个是map的对象:" + map.get("k"));
    }
    public void testScanner(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("This is me");
        String str = scanner.nextLine();
        System.out.println(str);
        scanner.close();
    }
    public void testConsole() {
        Console cons = System.console();
        String username = cons.readLine();
    }
    public void testFile() throws IOException {
        Scanner scanner = new Scanner(Paths.get("D:\\myfile.txt"),"UTF-8");
        String str = scanner.nextLine();
        System.out.println(str);
        scanner.close();
    }
    public void testWriterFile() throws IOException {
        PrintWriter printWriter = new PrintWriter("D:\\myfile.txt","UTF-8");
        printWriter.printf("就这个是我刚写进去的内容");
        System.out.println("操作完成");
        printWriter.close();

    }
    public void testForEach(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (int i : list) {
            i = 8;
        }
        System.out.println(list);
    }
    public void testDate(){
        LocalDate date = LocalDate.now();
        System.out.println("日:" + date.getDayOfMonth());
        LocalDate localDate = date.plusDays(3);
        System.out.println("新日:" + localDate.getDayOfMonth());
    }
    public String[] testQuote(String[] a){
        a[0] = "K";
        System.out.println(Arrays.toString(a));
        return a;
    }
    public String testString(String a){
        a = "K";
        System.out.println(a);
        return a;
    }
    public List<String> testList(List<String> a){
        a.add("wangx");
        System.out.println(a);
        return a;
    }
    public static String testStatic(String a){
        return a;
    }

    public void getT(){
        TestModel testModel = new TestModel();
        TestModelSon testModelSon = new TestModelSon();
        System.out.println(testModel instanceof TestModelSon);
        System.out.println(testModelSon instanceof TestModel);

        System.out.println(testModel.getClass() == testModelSon.getClass());
        System.out.println(testModelSon.getClass() == testModel.getClass());
    }
    public boolean equals(Object str){
        return str.equals("k");
    }

}
