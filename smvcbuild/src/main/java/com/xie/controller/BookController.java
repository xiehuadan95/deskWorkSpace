package com.xie.controller;

import com.xie.pojo.Books;
import com.xie.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller 调用service层
    @Autowired
    //指定一个唯一的bean注入
    @Qualifier("BookServiceImpl")
    private BookService bookService;
    //查询全部的书籍，并且返回一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allBook";
    }
    //新增书籍
    @RequestMapping("/toAddBook")
    public String add(Model model){

        return "addBook";
    }
    //添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBook"+books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }
    //跳转到修改页面
    @RequestMapping("/toUpdate")
    public String toUpdatePage(int id,Model model) {
        Books books = bookService.queryBookById(id);
        model.addAttribute("qBook",books);
        return "updateBook";
    }
    //修改书籍
    @RequestMapping("/updatebook")
    public String updateBook(Books books){
        System.out.println("=="+books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }
    //查询书籍
    @RequestMapping("/queryBook/{queryBookName}")
    public String queryBook(@PathVariable String queryBookName, Model model){
        Books books = bookService.queryBookName(queryBookName);
        System.out.println(books);
        List<Books> list=new ArrayList<>();
        list.add(books);
        model.addAttribute("list",list);

        return "allBook";
    }


}
