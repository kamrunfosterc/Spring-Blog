package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping(path = "/posts")
    @ResponseBody
    public String allPosts(){
        return "Posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String specificPosts(@PathVariable int id){
        return "View individual post " + id+" !";
    }


    @GetMapping("/posts/create")
    @ResponseBody
    public String viewAPost(){
        return "View form for creating a post";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String createAPost(){
        return "Create new Post";
    }



}
