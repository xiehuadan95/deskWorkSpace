package com.xie.study.array;

import java.util.Arrays;

/**
 * @author Eric
 * @since 1.8
 */


public class DemoArrays {
    public static void main(String[] args) {

        int[] a={1,2,3455,6576556,33,434,43,2,67};

        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        //填充
        Arrays.fill(a, 10);
        System.out.println(Arrays.toString(a));
        Arrays.fill(a, 2, 5, 55);
        System.out.println(Arrays.toString(a));

    }
}
