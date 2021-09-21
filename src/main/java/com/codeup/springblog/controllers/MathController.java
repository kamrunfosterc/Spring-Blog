package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/3/and/4")
    @ResponseBody // tells it that it'll return
    public long threePlusFour(){
        return 3+4;
    }

    @GetMapping("/add/3/and/4")
    @ResponseBody // tells it that it'll return
    public long tenMinusThree(){
        return 10-3;
    }

    @GetMapping("/add/3/and/4")
    @ResponseBody // tells it that it'll return
    public long fourTimesFive(){
        return 4*5;
    }

    @GetMapping("/add/3/and/4")
    @ResponseBody // tells it that it'll return
    public long  sixDividedByThree(){
        return 6/3;
    }

//    @GetMapping("/multi/{x_value}/and/{y_value}")
//    @ResponseBody
//    public long multiUserChoice(){
//        int x_value;
//        int y_value;
//        return ;
//    }
    //TRY THIS ONE AGAIN, NOT WORKING

}
