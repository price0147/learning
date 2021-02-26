import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author: wangxu
 * @date: 2021-02-23 11:43
 */
//练习Thread,实现多线程同步下载图片
public class ThreadTest2 extends Thread{
    private String url; //网络图片地址
    private String name; //保存图片名字

    public ThreadTest2(String url,String name){
        this.url = url;
        this.name = name;
    }

    @Override
    //下载图片的执行体
    public void run() {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downloader(url, name);
        System.out.println("下载了文件 : " + name);
    }

    public static void main(String[] args) {
        ThreadTest2 threadTest1 = new ThreadTest2("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fattachments.gfan.com%2Fforum%2Fattachments2%2F201304%2F18%2F001339jv88x0qs06vo3qq6.jpg&refer=http%3A%2F%2Fattachments.gfan.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1616644425&t=62d84e33b28332fa2fb2c0d82625c16a", "1.jpg");
        ThreadTest2 threadTest2 = new ThreadTest2("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fattachments.gfan.com%2Fforum%2Fattachments2%2F201304%2F18%2F001339jv88x0qs06vo3qq6.jpg&refer=http%3A%2F%2Fattachments.gfan.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1616644425&t=62d84e33b28332fa2fb2c0d82625c16a", "2.jpg");
        ThreadTest2 threadTest3 = new ThreadTest2("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fattachments.gfan.com%2Fforum%2Fattachments2%2F201304%2F18%2F001339jv88x0qs06vo3qq6.jpg&refer=http%3A%2F%2Fattachments.gfan.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1616644425&t=62d84e33b28332fa2fb2c0d82625c16a", "3.jpg");
        threadTest1.start();
        threadTest2.start();
        threadTest3.start();
    }
}
//下载器
class WebDownLoader{
    //下载方法
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常");
        }
    }

}
