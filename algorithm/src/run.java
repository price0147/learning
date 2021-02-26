import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import com.sun.tools.internal.ws.wsdl.document.Output;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import sun.nio.cs.ext.GBK;
import test.MyRunnable;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author: wangxu
 * @date: 2020/3/9 20:53
 */
public class run {

    public static void main(String[] args) throws IOException, InterruptedException {
        run r = new run();

        /*DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        System.out.println(dateFormat.format(new Date()));
        r.test1();*/

        /*r.test2();*/

        /*r.test3();*/

        /*r.test4();*/

        /*r.test5();*/

        /*r.test7();*/

        /*r.test8();*/

        /*r.test9();*/

        /*r.test10();*/

        /*r.test11(2);*/

        /*Optional optional = r.test12().flatMap(TestMethods::getOptional);
        System.out.println(optional.get());*/

        /*r.test13();*/

        /*r.test14();*/

        /*File file = new File("C:\\Users\\wangx\\Desktop\\aaa\\");
        r.test40(file);*/

        r.test41();
    }

    public void test(){
        File dir = new File("C:\\Users\\wangx\\Desktop\\a\\b\\c");
        if(dir.isDirectory()){
            dir.delete();
        }
    }


    /**
     * Properties:属性集合
     * 1. 存储属性名和属性值
     * 2. 属性名和属性值都是字符串类型
     * 3. 没有泛型
     * 4. 和流有关
     */
    public void test41() throws IOException {
        //创建一个集合
        Properties properties = new Properties();
        properties.setProperty("userName", "wangx");
        properties.setProperty("age", "25");
        System.out.println(properties.toString());
        //遍历
        //keSet
        for (Object o : properties.keySet()) {
            System.out.println((String) o);
        }
        //entrySet
        for (Object o : properties.entrySet()) {
            System.out.println(o);
        }
        //stringPropertyName
        Set<String> strings = properties.stringPropertyNames();
        for (String str : strings) {
            System.out.println(str + "-->" + properties.getProperty(str));
        }
        //和流有关的方法
        //----list-----
        PrintWriter printWriter = new PrintWriter("C:\\Users\\wangx\\Desktop\\23.txt");
        //传入一个打印流
        properties.list(printWriter);
        printWriter.close();
        //打印出来的结果
        /*
        -- listing properties --
        age=25
        userName=wangx
        */
        //保存方法----store方法----
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\wangx\\Desktop\\23.txt");
        properties.store(fileOutputStream,"我是一个注释,我可以随便写");
        fileOutputStream.close();
        //打印结果
        /*
        #\u6211\u662F\u4E00\u4E2A\u6CE8\u91CA,\u6211\u53EF\u4EE5\u968F\u4FBF\u5199
        #Tue Feb 09 15:09:08 CST 2021
        age=25
        userName=wangx
        */
        //加载方法----load方法----
        Properties properties1 = new Properties();
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\wangx\\Desktop\\23.txt");
        properties1.load(fileInputStream);
        fileInputStream.close();
        System.out.println(properties1.toString());
    }

    /**
     * 递归删除文件夹
     * @throws IOException
     */
    public void test40(File dir) throws IOException, InterruptedException {
        //这个返回一个File数组
        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                if(file.isDirectory()){
                    System.out.println("文件夹名字 --------> " + file.getName());
                    test40(file);
                    file.delete();
                }else{
                    System.out.println("以删除文件名字 --> " + file.getName());
                    file.delete();
                }
            }
        }

    }

    /**
     * 递归遍历文件夹
     * @throws IOException
     */
    public void test39(File dir) throws IOException, InterruptedException {
        //这个返回一个File数组
        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                if(file.isDirectory()){
                    System.out.println("文件夹名字 --------> " + file.getName());
                    test39(file);
                }else{
                    System.out.println("文件名字 --> " + file.getName());
                }
            }
        }

    }

    /**
     * FileFilter接口 -> 文件过滤器
     * @throws IOException
     */
    public void test38() throws IOException, InterruptedException {
        File dir = new File("C:\\Users\\wangx\\Pictures");
        //这个返回一个File数组
        File[] files = dir.listFiles(x -> x.getName().endsWith(".jpg"));
        for (File file : files) {
            System.out.println(file.getName());
        }
    }

    /**
     * File类的使用
     * 1.分隔符
     * 2.文件操作
     * -> 3.文件夹操作
     * @throws IOException
     */
    public void test37() throws IOException, InterruptedException {
        //创建文件夹
        File dir = new File("C:\\Users\\wangx\\Desktop\\aaa\\bbb");
        System.out.println(dir.toString());
        if (!dir.exists()) {
            //创建文件夹
            //dir.mkdir();//只能创建单级目录
            System.out.println("创建结果" + dir.mkdirs());//创建多级目录
        }
        //删除文件夹
        //直接删除(只删除bbb这一个目录,并且bbb一定是空的)
        //System.out.println("删除结果: " + dir.delete());
        //jvm删除
        //dir.deleteOnExit();
        //Thread.sleep(5000);
        //获取文件夹的信息
        System.out.println("获取绝对路径: " + dir.getAbsolutePath());
        System.out.println("获取路径: " + dir.getPath());
        System.out.println("获取文件夹名称: " + dir.getName());
        System.out.println("获取父目录: " + dir.getParent());
        System.out.println("获取创建时间: " + new Date(dir.lastModified()).toLocaleString());
        //判断
        System.out.println("是否是文件夹: " + dir.isDirectory());
        System.out.println("是否是隐藏: " + dir.isHidden());
        //遍历文件夹
        File dir1 = new File("C:\\Users\\wangx\\Pictures");
        //获取文件夹下的所有文件/文件夹的名字
        String[] files = dir1.list();
        //这个返回一个File数组
        File[] files1 = dir1.listFiles();
        for (String file : files) {
            System.out.println(file);
        }
    }

    /**
     * File类的使用
     * 1.分隔符
     * -> 2.文件操作
     * 3.文件夹操作
     * @throws IOException
     */
    public void test36() throws IOException, InterruptedException {
        System.out.println("路径分隔符" + File.pathSeparator);
        System.out.println("名称分隔符" + File.separator);

        //创建一个文件
        File file = new File("C:\\Users\\wangx\\Desktop\\File.txt");
        System.out.println(file.toString());
        //file.exists() 判断文件是否存在
        if(!file.exists()){
            boolean b = file.createNewFile();
            System.out.println("创建结果:" + b);
        }
        //删除文件
        //直接删除
        //System.out.println("删除结果" + file.delete());
        //使用jvm退出时删除
        //file.deleteOnExit();
        //Thread.sleep(5000);
        //获取文件信息
        System.out.println("获取文件的绝对路径" + file.getAbsolutePath());
        System.out.println("获取路径" + file.getPath());
        System.out.println("获取文件名称" + file.getName());
        System.out.println("获取父目录" + file.getParent());
        System.out.println("获取文件的长度" + file.length());
        System.out.println("文件的创建时间" + new Date(file.lastModified()).toLocaleString());
        //判断
        System.out.println("是否可写" + file.canWrite());
        System.out.println("是否是文件" + file.isFile());
        System.out.println("是否隐藏" + file.isHidden());

    }

    /**
     * 转换流:InputStreamReader
     * @throws IOException
     */
    public void test35() throws IOException{
        //声明一个字节流
        InputStream inputStream = new FileInputStream("C:\\Users\\wangx\\Desktop\\23.txt");
        //声明转换流
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"utf-8");
        //读取文件
        int count;
        char[] chars = new char[2048];
        while((count = inputStreamReader.read(chars)) != -1){
            System.out.println(new String(chars,0,count));
        }
    }

    /**
     * 转换流:OutputStreamWriter
     * @throws IOException
     */
    public void test34() throws IOException{
        //声明一个字节流
        OutputStream outputStream = new FileOutputStream("C:\\Users\\wangx\\Desktop\\23.txt",true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "GBK");
        outputStreamWriter.write("我的天!我是一个字节流,你看不懂我的");
        outputStreamWriter.flush();
        outputStreamWriter.close();
    }

    /**
     * 打印流使用 PrintWriter
     * @throws IOException
     */
    public void test33() throws IOException{
        //创建打印流
        PrintWriter pw = new PrintWriter("C:\\Users\\wangx\\Desktop\\23.txt");
        //打印
        pw.println(97);
        pw.println("我是爸爸");
        pw.println(3.141592653);
        pw.flush();
        pw.close();
    }

    /**
     * 字符缓冲流 BufferedWriter
     * @throws IOException
     */
    public void test32() throws IOException{
        //读入文件
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\wangx\\Desktop\\23.txt",true),2048);
        StringBuffer stringBuffer = new StringBuffer("我是测试问题");
        writer.write(stringBuffer.toString());
        writer.newLine();//换行
        writer.write("我成功换行了");
        //刷新缓存
        writer.flush();
        writer.close();
    }

    /**
     * 字符缓冲流 BufferedReader
     * @throws IOException
     */
    public void test31() throws IOException{
        //读入文件
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\wangx\\Desktop\\22.txt"),2048);
        char[] chars = new char[2048];
        //-----------------------------------------------------
        //第一种方式读取
//        StringBuffer stringBuffer = new StringBuffer();
//        int count;
//        while ((count = reader.read(chars)) != -1){
//            stringBuffer.append(new String(chars, 0, count));
//        }
        //------------------------------------------------------
        //第二种方式一行一行读
        String line = null;
        while((line = reader.readLine()) != null){
            System.out.println(line);
        }
        //------------------------------------------------------
        reader.close();
    }

    /**
     * 利用字节流进行赋值文件
     * 只能复制文本文件,不能赋值二进制文件,图片视频等
     */
    private void test30() throws IOException {
        //读入文件
        Reader reader = new BufferedReader(new FileReader("C:\\Users\\wangx\\Desktop\\22.txt"),2048);
        char[] chars = new char[2048];
        StringBuffer stringBuffer = new StringBuffer();
        int count;
        while ((count = reader.read(chars)) != -1){
            stringBuffer.append(new String(chars, 0, count));
        }
        reader.close();

        Writer writer = new BufferedWriter(new FileWriter("C:\\Users\\wangx\\Desktop\\23.txt",true),2048);
        writer.write(stringBuffer.toString());
        //刷新缓存
        writer.flush();
        writer.close();
    }

    /**
     * 字符流实例:writer
     * 字节流读中文由于编码的字节个数所以会乱码,字节流可以解决这个问题.
     */
    private void test29() throws IOException {
        Writer writer = new FileWriter("C:\\Users\\wangx\\Desktop\\22.txt",true);

        writer.write("我第三次成为了你爸爸");
        writer.close();
    }

    /**
     * 字符流实例:Reader
     * 字节流读中文由于编码的字节个数所以会乱码,字节流可以解决这个问题.
     */
    private void test28() throws IOException {
        Reader reader = new FileReader("C:\\Users\\wangx\\Desktop\\22.txt");
        char[] chars = new char[2048];
        int count;
        while ((count = reader.read(chars)) != -1){
            System.out.println(new String(chars,0,count));
        }
        reader.close();
    }

    /**
     * FileSystemResourceLoader
     */
    private void test27(){
        ResourceLoader resourceLoader = new FileSystemResourceLoader();
        Resource resource = resourceLoader.getResource("D:\\spring21site\\README");
        System.out.println(resource instanceof FileSystemResource);
    }

    /**
     * ObjectInPutStream:对象字节流
     */
    public void test26() {
        try {
            TestClass testClass = new TestClass();
            testClass.setAge(1);
            testClass.setName("wangx");
            testClass.setSex(2);
            InputStream inputStream = new FileInputStream("C:\\Users\\wangx\\Desktop\\22.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            TestClass test = (TestClass)objectInputStream.readObject();
            System.out.println(test);
            objectInputStream.close();
        }catch (Exception  e){
            e.printStackTrace();
        }
    }

    /**
     * ObjectOutPutStream:对象字节流
     */
    public void test25() {
        try {
            TestClass testClass = new TestClass();
            testClass.setAge(1);
            testClass.setName("wangx");
            testClass.setSex(2);
            OutputStream outputStream = new FileOutputStream("C:\\Users\\wangx\\Desktop\\22.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(testClass);
            objectOutputStream.flush();
            objectOutputStream.close();
        }catch (Exception  e){
            e.printStackTrace();
        }

    }

    /**
     * 使用bufferedOutputStream:缓冲字节流
     */
    public void test24() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\wangx\\Desktop\\22.txt");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            String str = "我天";
            bufferedOutputStream.write(str.getBytes());
            //刷新缓冲区
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        }catch (Exception  e){
            e.printStackTrace();
        }

    }

    /**
     * 使用bufferedInputStream:缓冲字节流
     */
    public void test23() {
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\wangx\\Desktop\\22.txt");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            //这个属于自己创建了一个缓冲区.如果不用数组直接读,会给一个默认的缓冲区8k
            byte[] bytes = new byte[2048];
            int count;
            while ((count = bufferedInputStream.read(bytes)) != -1) {
                System.out.println(new String(bytes,0,count));
            }
            bufferedInputStream.close();
        }catch (Exception  e){
            e.printStackTrace();
        }

    }
    /**
     * 测试打印文本
     */
    public void test22() {
        try {
            //如果FileOutputStream 有构造方法,有true则会在原来位置上追加
            OutputStream outputStream = new FileOutputStream("C:\\Users\\wangx\\Desktop\\22.txt");
            String str = "测试问题";
            outputStream.write(str.getBytes());
            outputStream.close();
        }catch (Exception  e){
            e.printStackTrace();
        }

    }

    /**
     * 测试打印文本
     */
    public void test21() {
        try {
            InputStream inputStream = new FileInputStream("C:\\Users\\wangx\\Desktop\\22.txt");
            //一个字节一个字节读
            int date;
//            while ((date = inputStream.read()) != -1) {
//                System.out.println(date);
//            }

            byte[] bt = new byte[2];
//            //返回的是读取的字节数
//            int read = inputStream.read(bt);
//            String s = new String(bt);
//            System.out.println(s);
//            System.out.println(read);
//            int read1 = inputStream.read(bt);
//            System.out.println(new String(bt,0,read1));

            //循环读取文本
            int count;
            while ((count = inputStream.read(bt)) != -1) {
                System.out.println(new String(bt,0,count));
            }
        }catch (Exception  e){
            e.printStackTrace();
        }

    }

    /**
     * 测试
     */
    public void test20() {
        testImpl test = new testImpl();
        Class<?> aClass = test.getClass();
        aClass = aClass.getSuperclass();
        System.out.println(aClass);

    }

    public void testw(List<TestClass> list) {
        Iterator<TestClass> iterator = list.iterator();
        if (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }

    }

    /**
     * 测试打印文本
     */
    public void test19() {
        try {
            /*
            PrintWriter out = new PrinWriter(
                new FileOutputStream("C:\Users\wangx\Desktop\TestDome.txt","UTF-8");
                下面是简写
             */
            //如果PrintWriter写出器设置为自动冲刷模式,那么只要println被调用,缓冲区中的所有字符都会被发送到它们的目的地(打印写入器总是带缓冲区的).
            // 默认情况下,自动冲刷机制是禁用的.你可以通过使用PrintWriter(Writer out,Boolean autoFlush)来启用或禁用自动冲刷机制
            PrintWriter out = new PrintWriter("C:\\Users\\wangx\\Desktop\\TestDome.txt", "UTF-8");
            out.print("我是你爸爸");
            out.print(" ");
            out.print("黑凤梨!!!!");
            out.println("哈哈哈!!!");
            out.close();
        }catch (Exception  e){
            e.printStackTrace();
        }

    }

    /**
     * 测试DataInputStream
     */
    public void test18() {
        try {
            File file = new File("C:\\Users\\wangx\\Desktop\\TestDome.txt");
            InputStream inputStream = new DataInputStream(new FileInputStream(file));
            byte[] chr = new byte[1024];
            StringBuffer stringBuffer = new StringBuffer();
            int result;
            //返回的读取的字节数
            while ((result = inputStream.read()) != -1){
                stringBuffer.append(new String(chr,0,result));
            }
            System.out.println(stringBuffer.toString());
            inputStream.close();
        }catch (Exception  e){
            e.printStackTrace();
        }

    }

    /**
     * 写入一个文件
     */
    public void test17(){
        try {
            //大家注意下第二个参数
            //此构造方法为重载方法
            //有带一个参数的如:fos = new FileOutputStream(file)这种,
            //也有像下面这种带两个参数的, 其实如果不写实际上就是 第二个参数默认为false;
            //第二个参数表示是否在源文件已有内容的后面进行追加写入新的内容,
            //即true表示在原有内容的基础上进行追加写入写内容; false表示覆盖擦除原有内容,
            //写入后只包含新写入内容, 原有内容将会被覆盖不存保留 , 至于这点大家可以自行去验证
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\wangx\\Desktop\\TestDome.txt",true);

            String str = "我想写入的内容";
            //转码
            byte[] chars = str.getBytes();
            fileOutputStream.write(chars);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 解决下面的中文乱码的问题.
     */
    public void test16() {
        try {
            File file = new File("C:\\Users\\wangx\\Desktop\\TestDome.txt");
            InputStream inputStream = new FileInputStream(file);
            byte[] chr = new byte[1024];
            StringBuffer stringBuffer = new StringBuffer();
            int result;
            //返回的读取的字节数
            while ((result = inputStream.read(chr)) != -1){
                stringBuffer.append(new String(chr,0,result));
            }
            System.out.println(stringBuffer.toString());
            inputStream.close();
        }catch (Exception  e){
            e.printStackTrace();
        }

    }

    /**
     * 问题:由于流是面向字节,汉字普遍为2个字节所以显示的时候会乱码
     * 读取文件,存在中文乱码的问题.
     */
    public void test15() {
        try {
            File file = new File("C:\\Users\\wangx\\Desktop\\TestDome.txt");
            InputStream inputStream = new FileInputStream(file);
            int result;
            while ((result = inputStream.read()) != -1){
                System.out.print((char)result);
            }
            inputStream.close();
        }catch (Exception  e){
            e.printStackTrace();
        }

    }

    public void test14(){

        Runnable threadJob = new MyRunnable();
        Thread myThread = new Thread(threadJob);
        myThread.start();
        for(char a = 'A';a < 'a';a++){
            System.out.println(a);
        }
    }

    public Integer DoubleCompare(Double a,Double b){
        BigDecimal bigDecimalA = new BigDecimal(a);
        BigDecimal bigDecimalB = new BigDecimal(b);
        return bigDecimalA.compareTo(bigDecimalB);
    }

    //静态的Thread.getAllStackTrace方法,它可以产生所有线程的堆栈轨迹.下面给出使用这个方法的具体方式:
    public void test1(){
        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
        for (Thread t : map.keySet()) {
            StackTraceElement[] frames = map.get(t);
            for (StackTraceElement stackTraceElement : frames) {
                System.out.println(stackTraceElement.getClassName());
                System.out.println(stackTraceElement.getLineNumber());
                System.out.println(stackTraceElement.getMethodName());
                System.out.println(stackTraceElement.getFileName());
            }
        }
    }
    //迭代器的使用
    public void test2(){
        List<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()) {
            if(aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }

        System.out.println(a);

        bIter = b.iterator();
        while (bIter.hasNext()) {
            bIter.next();
            if (bIter.hasNext()) {
                bIter.next();
                bIter.remove();
            }
        }

        System.out.println(b);

        a.removeAll(b);

        System.out.println(a);
    }
    //LinkedHashSet和LinkedHashMap的使用
    public void test3(){
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("2");
        linkedHashSet.add("3");
        LinkedHashSet<Integer> linkedHashSet1 = new LinkedHashSet<>();
        linkedHashSet1.add(1);
        linkedHashSet1.add(2);
        linkedHashSet1.add(3);

        System.out.println(linkedHashSet1.spliterator().characteristics());
        System.out.println(linkedHashSet.spliterator().characteristics());


        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("123", "wangx");
        linkedHashMap.put("321", "haha1");
        linkedHashMap.put("789", "77");
        linkedHashMap.keySet().stream().forEach(x -> System.out.println(x));
        linkedHashMap.values().stream().forEach(x -> System.out.println(x));
    }

    //视图测试
    public void test4(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        List<Integer> integers = list.subList(1, 3);
        List<Integer> integers1 = Collections.unmodifiableList(list);
        integers.add(8);
        System.out.println(integers);
        System.out.println(list);
    }

    //测试parallelStream()异步执行
    public void test5(){
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        list.parallelStream().forEach(x -> System.out.println(x));
        System.out.println("我是你爸爸");
    }

    //测试创建一个无限流的方法
    public void test6(){
        Stream<String> generate = Stream.generate(() -> "wangxi");
        Stream<BigInteger> iterate = Stream.iterate(BigInteger.ZERO, x -> x.add(BigInteger.ONE));
    }

    //测试anyMatch,allMatch,noneMatch
    public void test7(){
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(35);
        System.out.println(list.stream().anyMatch(x -> x == 25));
        System.out.println(list.stream().anyMatch(x -> x == 2));
        System.out.println("----------------------");
        System.out.println(list.stream().allMatch(x -> x == 25));
        System.out.println(list.stream().allMatch(x -> x == 2));
        System.out.println("----------------------");
        System.out.println(list.stream().noneMatch(x -> x == 25));
        System.out.println(list.stream().noneMatch(x -> x == 2));
    }

    //测试anyMatch,allMatch,noneMatch
    public void test9(){
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(35);
        Optional<Integer> any = list.stream().limit(0).findAny();
        any.ifPresent(x -> System.out.println(x));

        //System.out.println(any.map(x -> x).get());
    }

    //测试Optional isPresent()和someMethod();
    public void test10(){
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(35);
        Optional<Integer> any = list.stream().limit(0).findAny();
        if(any.isPresent()){
            Integer i = any.get();
            System.out.println(i);
        }
        //System.out.println(any.map(x -> x).get());
    }

    //测试创建Optional;
    public void test11(int x){
        Optional optional = x == 0 ? Optional.empty() : Optional.of(1 / x);
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }
    }

    //测试创建Optional;
    public Optional<TestMethods> test12(){
        TestMethods testMethods = new TestMethods();
        return Optional.of(testMethods);
    }

    public void test13(){
        List<String> listString = new ArrayList<>();
        listString.add("2");
        listString.add("3");
        listString.add("35");
        listString.add("3");

        List<Integer> listInteger = new ArrayList<>();
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(35);
        Iterator<Integer> iterator = listInteger.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == 3) {
                iterator.remove();
            }
        }
        Integer integer1 = listInteger.stream().reduce(5,Integer::sum);
        Integer integer2 = listInteger.stream().reduce(0,Integer::max);
        Integer integer3 = listString.stream().reduce(0,(total,word) -> {
            return total + word.length();
        },(total1,total2) -> {
            return total1 + total2;
        });

        System.out.println("integer1" + "==" + integer1);
        System.out.println("integer2" + "==" + integer2);
        System.out.println("integer3" + "==" + integer3);
    }
}