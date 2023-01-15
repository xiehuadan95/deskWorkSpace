package atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Author:Eric
 * DATE:2023/1/11-20:30
 * Decription: 原子更新数组类型
 */
public class AtomicIntegerArrayTest {
    static int[] value=new int[]{1,2,3,4,5};
    static AtomicIntegerArray atomicIntegerArray=new AtomicIntegerArray(value);

    public static void main(String[] args) {
        //设置索引0的元素为100
        atomicIntegerArray.set(0,100);
        System.out.println(atomicIntegerArray.get(0));
        //以原子更新的方式将数组中索引为1的元素与输入值相加
        atomicIntegerArray.getAndAdd(1,5);
        System.out.println(atomicIntegerArray);
    }
}
