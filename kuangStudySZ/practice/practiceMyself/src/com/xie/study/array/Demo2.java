package com.xie.study.array;

public class Demo2 {
    public static void main(String[] args) {
        int[] arrays={1,2,3,4,5,6};
        for (int num:arrays) {
            System.out.println(num);
        }
        System.out.println("=======================");
        //找到数组中最大的值
        int max=arrays[0];
        for (int i = 1; i < arrays.length; i++) {
            if(arrays[i]>max){
                max=arrays[i];
            }
        }
        System.out.println("最大值是："+max);

    }
}
