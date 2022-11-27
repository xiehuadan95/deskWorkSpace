package com.xie.study.struct;

public class ForDemo {
    public static void main(String[] args) {
        int a=1;
        for (int i = 1; i <=100 ; i++) {
            System.out.println(i);
        }
        //死循环for(;;){}

        int oddSum=0;
        int evenSum=0;
        for (int i = 1; i <=100; i++) {
            if(i%2!=0){
                oddSum+=i;
            }else{
                evenSum+=i;
            }
        }
        System.out.println("100以内偶数的和==="+evenSum);
        System.out.println("100以内奇数的和==="+oddSum);
    }
}
