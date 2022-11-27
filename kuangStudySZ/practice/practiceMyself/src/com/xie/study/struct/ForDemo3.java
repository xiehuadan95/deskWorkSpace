package com.xie.study.struct;

/**
 * @author Eric
 * @since 1.8
 */
public class ForDemo3 {
    //九九乘法表
    public static void main(String[] args) {

        for (int i=1; i<10 ; i++) {
            for (int j = 1; j <=i; j++) {
                System.out.print(i+"*"+j+"="+(j*i)+"\t");
                if(i==j){
                    System.out.println();
                    continue;
                }
            }

        }
        System.out.println("=====================");
        int i=0;
        while (i<100){
            i++;
            if(i%10==0){
                System.out.println();
                continue;
            }
            System.out.println(i);
        }



    }
}
