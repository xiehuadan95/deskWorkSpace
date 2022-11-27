package com.xie.study.bass;


/**
 * @author  EricXie
 * @version 1.0
 * @since 1.8
 */
//生成文档
public class Doc {
    String name ;

    /**
     *
     * @param name
     * @return
     */
    public String test(String name){
        return name;
    };

    /**
     * @author EricXie
     * @param name
     * @return
     * @throws Exception
     */
    public String test2(String name) throws Exception{
        return name+1;
    };


}
