package com.xie.study.reflection;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Test04 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载器的父类加载器--->扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println("扩展类加载器："+parent);
        //获取扩展类加载器的父类加载器--->根加载器（c/c++）
        ClassLoader parent1 = parent.getParent();
        System.out.println("根加载器："+parent1);
        System.out.println("============分割线============");
        //测试当前类是哪个加载器加载的
        ClassLoader  classLoader = Class.forName("com.xie.study.reflection.Test04").getClassLoader();
        System.out.println(classLoader);
        //测试JDK内置的类是谁加载的 （根）
        classLoader=Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);

        //如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));

        //双亲委派机制
        //多重检测保证安全性
/*
C:\Program Files\Java\jdk1.8.0_161\jre\lib\charsets.jar;
C:\Program Files\Java\jdk1.8.0_161\jre\lib\deploy.jar;
C:\Program Files\Java\jdk1.8.0_161\jre\lib\ext\access-bridge-64.jar;
C:\Program Files\Java\jdk1.8.0_161\jre\lib\ext\cldrdata.jar;
C:\Program Files\Java\jdk1.8.0_161\jre\lib\ext\dnsns.jar;
C:\Program Files\Java\jdk1.8.0_161\jre\lib\ext\jaccess.jar;
C:\Program Files\Java\jdk1.8.0_161\jre\lib\ext\jfxrt.jar;
C:\Program Files\Java\jdk1.8.0_161\jre\lib\ext\localedata.jar;
C:\Program Files\Java\jdk1.8.0_161\jre\lib\ext\nashorn.jar;
C:\Program Files\Java\jdk1.8.0_161\jre\lib\ext\sunec.jar;
C:\Program Files\Java\jdk1.8.0_161\jre\lib\ext\sunjce_provider.jar;
C:\Program Files\Java\jdk1.8.0_161\jre\lib\ext\sunmscapi.jar;
C:\Program Files\Java\jdk1.8.0_161\jre\lib\ext\sunpkcs11.jar;
C:\Program Files\Java\jdk1.8.0_161\jre\lib\ext\zipfs.jar;
C:\Program Files\Java\jdk1.8.0_161\jre\lib\javaws.jar;
C:\Program Files\Java\jdk1.8.0_161\jre\lib\jce.jar;
C:\Program Files\Java\jdk1.8.0_161\jre\lib\jfr.jar;
C:\Program Files\Java\jdk1.8.0_161\jre\lib\jfxswt.jar;
C:\Program Files\Java\jdk1.8.0_161\jre\lib\jsse.jar;
C:\Program Files\Java\jdk1.8.0_161\jre\lib\management-agent.jar;
C:\Program Files\Java\jdk1.8.0_161\jre\lib\plugin.jar;
C:\Program Files\Java\jdk1.8.0_161\jre\lib\resources.jar;
C:\Program Files\Java\jdk1.8.0_161\jre\lib\rt.jar;
D:\IDEA2021\IdeaWorkSpace\practice\out\production\practiceMyself;
D:\IDEA2021\IntelliJ IDEA 2021.1.1\lib\idea_rt.jar


 */

    }
}
