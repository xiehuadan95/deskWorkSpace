## 常用依赖
```xml
   <dependency>
         <groupId>org.springframework</groupId>
         <artifactId>spring-webmvc</artifactId>
         <version>5.3.13</version>
     </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
        </dependency>

```
## 自动装配的xml 可自行加AOP约束
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">
    <!--开启注解支持-->
    <context:annotation-config/>

```
## 注解说明
@Autowired :自动装配 通过类型 名字
如果Autowired不能唯一自动装配上属性，则需要通过@Qulifier（value="xxx")
@Nullable 字段标记了这个注解，说明这个字段可以为null
@Resource ：自动装配 通过名字 类型

@Component: 组件，放在类上，说明这个类被Spring管理了，就是bean!