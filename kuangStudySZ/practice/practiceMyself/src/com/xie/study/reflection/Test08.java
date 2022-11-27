package com.xie.study.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

//通过反射获取泛型
public class Test08 {

    public void test01(Map<String,User> map, List<User> list){
        System.out.println("test01");

    }
    public Map<String,User> test02(){
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Test08.class.getMethod("test01", Map.class, List.class);
        //获得方法里的参数类型
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            //能获得类的信息，里面泛型的具体信息还需要遍历
            System.out.println("a"+genericParameterType);
            //如果属于结构化参数化类型 则去获得真实的参数类型  先强转然后获得真实类型
            if(genericParameterType instanceof ParameterizedType){
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println("泛型的参数信息"+actualTypeArgument);
                }
            }
        }
        System.out.println("====================================");

        method = Test08.class.getMethod("test02", null);
        Type genericParameterTypes1 = method.getGenericReturnType();

            //如果返回类型 属于结构化参数化类型 则去获得真实的参数类型  先强转然后获得真实类型
            if(genericParameterTypes1 instanceof ParameterizedType){
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterTypes1).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println("返回值泛型的参数信息"+actualTypeArgument);
                }
            }

       }

    }


