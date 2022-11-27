package com.xie.study.array;


import java.util.Arrays;

/**
 * @author Eric
 * 冒泡排序
 * @since 1.8
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a={1,566,153,123,4,1,51,1310,122,223,10,120};
        System.out.println(Arrays.toString(a));
      int[] b= bubbleSort(a);
        System.out.println(Arrays.toString(b));



    }
    //比较数组中两个相邻的元素，如果第一个数比第二个数大就交换位置，每一次比较都会产生一个最大数或最小数字
    //下一次则少一轮，依次循环
    public static int[] bubbleSort(int[] array){
        //以此为表示减少没有意义的比较
        boolean flag=false;
        //临时变量
        int temp;
        //外层循环，判断我们要两两比较多少次
        for (int i = 0; i <array.length-1 ; i++) {
        //内层循环，比较判断两个数，如果第一个数比第二个数大，则交换位置
            for (int j = 0; j <array.length-1-i ; j++) {
                if(array[j+1]<array[j]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    flag=true;
                }
            }
            if(flag==false){
                break;
            }

        }
        return array;

    }

}
