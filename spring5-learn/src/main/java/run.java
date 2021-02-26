import com.wangx.springlearn.ApplicationMethodExeuctionEventPublisher;
import com.wangx.springlearn.MethodExeuctionEventPublisher;
import com.wangx.springlearn.SimpleMethodExecutionEventListener;
import com.wangx.springlearn.config.AppConfig;
import com.wangx.springlearn.config.MyBeanFactoryPostProcessorImpl;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author: wangxu
 * @date: 2020-12-22 21:32
 */
public class run{

    public static void main(String[] args) throws IOException {
        //加载容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        /*MethodExeuctionEventPublisher eventPublisher = new MethodExeuctionEventPublisher();
        eventPublisher.addMethodExecutionEventListener(new SimpleMethodExecutionEventListener());
        eventPublisher.methodToMonitor();*/

        ApplicationMethodExeuctionEventPublisher applicationMethodExeuctionEventPublisher = (ApplicationMethodExeuctionEventPublisher) ac.getBean("applicationMethodExeuctionEventPublisher");
        applicationMethodExeuctionEventPublisher.methodToMonitor();

    }

    /**
     * 演示使用ResourceLoader(接口)
     */
    public void test1() throws IOException {
        /*
            演示使用ResourceLoader(接口)
            FileSystemResourceLoader()
            DefaultResourceLoader()
         */
        //DefaultResourceLoader(实现类)
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource fakeResource = resourceLoader.getResource("file:C:\\Users\\wangx\\Desktop\\22.txt");
        System.out.println(fakeResource instanceof ClassPathResource);
        //FileReader fileReader = new FileReader(fakeResource.getFile());
        System.out.println(fakeResource.exists());
        InputStream inputStream = fakeResource.getInputStream();
        //char[] chr = new char[1024];
        byte[] chr = new byte[1024];
        int result;
        //返回的读取的字节数
        while ((result = inputStream.read(chr)) != -1){
            System.out.println(new String(chr,0,result));
        }

        inputStream.close();
    }

    /**
     * ResourcePatternResolver演示 --批量查找的ResourceLoader
     */
    public void test2() throws IOException{
        FileSystemResourceLoader fileSystemResourceLoader = new FileSystemResourceLoader();
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver(fileSystemResourceLoader);
        Resource[] resources = resourcePatternResolver.getResources("file:D:/workspace/learning/spring5-learn/**/*.class");
        if(resources.length != 0){
            for (Resource resource : resources) {
                System.out.println(resource.getURL());
            }
        }
    }


}
