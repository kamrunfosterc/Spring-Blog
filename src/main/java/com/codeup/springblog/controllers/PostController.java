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
    public String userIdPosts(@PathVariable int id){
        return "View individual post " + id+" !";
    }


    @GetMapping("/post/create")
    @ResponseBody
    public String viewAPost(){
        return "View form for creating a post";
    }

    //todo my version
    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String createAPost(){
        return "Create new Post";
    }

    @PostMapping("/posting/create")
    @ResponseBody
    public String createPost(){
        return "create a new post";
    }



}
