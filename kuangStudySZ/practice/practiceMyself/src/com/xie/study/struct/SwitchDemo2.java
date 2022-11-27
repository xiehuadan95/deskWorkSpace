package com.xie.study.struct;

public class SwitchDemo2 {
    public static void main(String[] args) {
        // 可以用 byte short int char String(字面量 常量) enum

        String  name="中国";
        switch (name){
            case "英国":
                System.out.println("a");
                break;
            case "美国":
                System.out.println("b");
                break;
            case "中国":
                System.out.println("haha");
                break;
            default:
                System.out.println("未知数据");
        }
        //java ----class(字节码文件)---反编译（IDEA)


    }
}
