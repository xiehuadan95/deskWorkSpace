package com.xie.study.method;

/**
 * @author Eric
 * @since 1.8
 */
public class Demo1 {
    public static void main(String[] args) {
        int max = max(50, 50);
        System.out.println(max);
    }
    //比大小
    public static int max(int num1, int num2) {
        int result = 0;
        if (num1 > num2) {
            result = num1;
        } else if (num1 == num2) {
            System.out.println("num1=num2");
            //用return阻断
            return 0;
        } else {
            result = num2;
        }
        return result;
    }

}
