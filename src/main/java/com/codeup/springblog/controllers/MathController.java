package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
//public class MathController {
//
//    @GetMapping("/add/3/and/4")
//    @ResponseBody // tells it that it'll return
//    public long threePlusFour(){
//        return 3+4;
//    }
//
//    @GetMapping("/subtract/3/from/10")
//    @ResponseBody // tells it that it'll return
//    public long tenMinusThree(){
//        return 10-3;
//    }
//
//    @GetMapping("/multiply/4/and/5")
//    @ResponseBody // tells it that it'll return
//    public long fourTimesFive(){
//        return 4*5;
//    }
//
//    @GetMapping("/divide/6/by/3")
//    @ResponseBody // tells it that it'll return
//    public long  sixDividedByThree(){
////        int answer = 6/3;// if we wanted to return string and concatinate
////        return "6 / 3 = "+answer;
//        return 6/3;
//    }
//
//    //used when we don't know any variables
//    @GetMapping("/multi/{x_value}/and/{y_value}")
//    @ResponseBody
//    public int multiUserChoice(@PathVariable int x_value, @PathVariable int y_value){
//        return x_value * y_value;
//    }
//
//
//}


// TODO: 9/25/21 redoing Mathcontroller exercise
//This controller should listen for requests for several routes that correspond to basic arithmetic operations
// and produce the result of the arithmetic.

@Controller
public class MathController {
    @GetMapping("/add/3/and/4")
    @ResponseBody
    public int addThreeAndFour(){
        return 3+4;
    }
    @GetMapping("/subtract/3/from/10")
    @ResponseBody
    public int subThreeAndTen(){
        return 10-3;
    }
    @GetMapping("/multiply/4/and/5")
    @ResponseBody
    public int multiFourAndFive(){
        return 4*5;
    }
    @GetMapping("/divide/6/by/3")
    @ResponseBody
    public long divSixAndThree(){
        return 6/3;
    }


    //TODO alternative way so that value is returned
    @GetMapping("/add/{x}/and/{y}")
    @ResponseBody
    public String addUserInput(@PathVariable int x, @PathVariable int y){
        String userInput = "We've added your values, the result is: ";
        long answer = x+y;
        return userInput + answer;
    }
    @GetMapping("/subtract/{x}/and/{y}")
    @ResponseBody
    public String subtractUserInput(@PathVariable int x, @PathVariable int y){
        String userInput = "We've subtracted your values, the result is: ";
        long answer = x-y;
        return userInput + answer;
    }
    @GetMapping("/multiply/{x}/and/{y}")
    @ResponseBody
    public String multiplyUserInput(@PathVariable int x, @PathVariable int y){
        String userInput = "We've multiplied your values, the result is: ";
        long answer = x*y;
        return userInput + answer;
    }
    @GetMapping("/divide/{x}/and/{y}")
    @ResponseBody
    public String divideUserInput(@PathVariable int x, @PathVariable int y){
        String userInput = "We've divided your values, the result is: ";
        long answer = x/y;
        return userInput + answer;
    }
}


