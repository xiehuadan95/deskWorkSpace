package com.xie.study.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.*;

//实习callable 有返回值
// callable可以定义返回值  可以抛出异常
public class TestCallable implements Callable<Boolean> {
    //网图地址
    private String url;
    //保存的文件名
    private String name;

    //构造器
    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    //下载图片的线程执行体
    @Override
    public Boolean call() throws MalformedURLException {
        WebDownloader2 webDownloader = new WebDownloader2();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为：" + name);
        return true;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://i0.hdslb.com/bfs/space/265ecddc52d74e624dc38cf0cff13317085aedf7.png@2560w_400h_100q_1o.webp", "c1.jpg");
        TestCallable t2 = new TestCallable("https://i0.hdslb.com/bfs/space/265ecddc52d74e624dc38cf0cff13317085aedf7.png@2560w_400h_100q_1o.webp", "c2.jpg");
        TestCallable t3 = new TestCallable("https://i0.hdslb.com/bfs/space/265ecddc52d74e624dc38cf0cff13317085aedf7.png@2560w_400h_100q_1o.webp", "c3.jpg");

        //创建执行服务： new了一个池子
        ExecutorService ser = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);

        //获取结果
       boolean rs1= r1.get();
        boolean rs2= r2.get();
        boolean rs3= r3.get();
        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);

        //关闭服务
        ser.shutdown();
    }
}
class WebDownloader2{
    //下载方法
    public void downloader(String url,String name) throws MalformedURLException {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("io异常，downloader方法出现问题");
        }
    }

}


