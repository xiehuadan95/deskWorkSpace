package com.xie.demo2;

public class UserServiceProxy implements UserService{
    UserServiceImpl userService;
   //用set方式实现注入
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }
    @Override
    public void add() {
      log("add");
        userService.add();
    }
    @Override
    public void delete() {
        log("delete");
        userService.delete();
    }
    @Override
    public void update() {
        log("update");
        userService.update();
    }
    @Override
    public void query() {
        log("query");
        userService.query();
    }
    //增加日志方法
    public void log(String msg){
        System.out.println("[Debug] 使用了"+msg+"方法");
    }

}
