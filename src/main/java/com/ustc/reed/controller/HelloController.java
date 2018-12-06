package com.ustc.reed.controller;

import com.ustc.reed.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private Book book;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        return book.getAuthor();
    }

    @RequestMapping(value = "/hello/{price}",method = RequestMethod.GET)
    public Integer price(@PathVariable("price") Integer price){
        return price;
    }

    @GetMapping(value = "/haha")
    public Integer welcome(@RequestParam(value = "id",required = false,defaultValue = "0") Integer price){
        return price;
    }




}
