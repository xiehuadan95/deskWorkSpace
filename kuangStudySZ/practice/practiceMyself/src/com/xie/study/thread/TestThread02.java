package com.xie.study.thread;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

//联系Thread,实现多线程同步下载图片
public class TestThread02 extends Thread{
    //网图地址
    private String url;
    //保存的文件名
    private String name;
    //构造器
    public  TestThread02(String url,String name){
        this.url=url;
        this.name=name;
    }
  //下载图片的线程执行体
  @Override
  public void run(){
    WebDownloader webDownloader=new WebDownloader();
      try {
          webDownloader.downloader(url, name);
      } catch (MalformedURLException e) {
          e.printStackTrace();
      }
      System.out.println("下载了文件名为："+name);
  }

    public static void main(String[] args) {
        TestThread02 t1=new TestThread02("https://i0.hdslb.com/bfs/space/265ecddc52d74e624dc38cf0cff13317085aedf7.png@2560w_400h_100q_1o.webp","b1.jpg");
        TestThread02 t2=new TestThread02("https://i0.hdslb.com/bfs/space/265ecddc52d74e624dc38cf0cff13317085aedf7.png@2560w_400h_100q_1o.webp","b2.jpg");
        TestThread02 t3=new TestThread02("https://i0.hdslb.com/bfs/space/265ecddc52d74e624dc38cf0cff13317085aedf7.png@2560w_400h_100q_1o.webp","b3.jpg");
        t1.start();
        t2.start();
        t3.start();
        //先下载的2，再下载的1,再下载的3
    }


}
//下载器
class WebDownloader{
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
