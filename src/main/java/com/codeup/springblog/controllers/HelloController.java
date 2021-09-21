package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller //first thing we do here
public class HelloController {

    @GetMapping("/")// sim to a doGet
    @ResponseBody // tells it that it'll return
    public String helloFromSpring(){
        return "Hello from the world of Spring Boot";
    }

    @GetMapping("/helloworld/{username}")// added 'path variable'
    @ResponseBody
    public String helloWorld(@PathVariable String username){
        return "Hello"+username+"!";
    }

    //controller for ads, users etc...

    @GetMapping("/happy_birthday/{username}/{age}")// added 'path variable'
    @ResponseBody
    public String howOld(
            @PathVariable String username,
            @PathVariable int age
    ){
        return "Happy Birthday, "+username+ " you are now "+age+ " years old.";
    }

    //todo example 3
    @GetMapping("/random/number")// added 'path variable'
    @ResponseBody
    public int RandomNumber(){
        Random r = new Random();
        int low = 1;
        int high = 100;
        return r.nextInt(high-low)+low;
    }

}
