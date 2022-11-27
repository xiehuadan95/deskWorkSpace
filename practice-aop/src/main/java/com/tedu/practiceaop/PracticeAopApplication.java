package com.tedu.practiceaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class PracticeAopApplication {


    public static void main(String[] args) throws IOException {
        SpringApplication.run(PracticeAopApplication.class, args);
       new ThisEscape();
        System.in.read();

    }


}
 class ThisEscape{
    private int num=8;
    public ThisEscape(){
    new Thread(()->System.out.println(this.num)).start();}
}