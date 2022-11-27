package com.xie.study.array;

public class Demo {
    public static void main(String[] args) {

        //声明一个数组
        int[] nums;
        //以下写法跟c有关方便理解
        int nums2[];
        //定义：
        nums =new int [10];
        System.out.println(nums.length);
        //给数组内的元素赋值

        nums[0]=1;
        nums[1]=2;
        nums[2]=4;
        nums[3]=10;
        nums[4]=100;
        System.out.println(nums[2]);
        int sum=0;
        for (int i = 0; i <nums.length ; i++) {
            sum+=nums[i];
        }
        System.out.println(sum);
        //静态初始化  创建+赋值
        int[] a ={2,3,5,0,23,234};
        int[] b= new int[0];
        System.out.println(b.length);



    }
}
