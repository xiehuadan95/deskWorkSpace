package com.xie.study.array;

import java.util.Arrays;

public class Demo3 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        printArray(array);
        int[][] arrays = new int[4][2];
        int[][] arrays2 = {{1, 2}, {2, 3}, {3, 4}, {5, 6}};

        System.out.println(arrays2[0][0]);
        for (int i = 0; i < arrays2.length; i++) {
            for (int j = 0; j <arrays2[i].length ; j++) {
                System.out.println(arrays[i][j]);
            }
        }
    }

    private static int[] printArray(int[] a) {
        //先创建需要返回的数组，长度要一致
        int[] result = new int[a.length];
        //反转
        for (int i = 0, j = result.length - 1; i < a.length; i++, j--) {
            result[j] = a[i];
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
}
