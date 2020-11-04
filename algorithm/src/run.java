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

    public static void main(String[] args) {
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

        LocalDate localDate = LocalDate.now();
        int value = localDate.getDayOfWeek().getValue();
        LocalDate localDate1 = localDate.minusDays(value - 1);
        System.out.println(localDate1);
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