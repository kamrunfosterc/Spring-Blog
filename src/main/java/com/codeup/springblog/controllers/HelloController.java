package com.codeup.springblog.controllers;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller //first thing we do here
public class HelloController {

    @GetMapping("/hello")// sim to a doGet, define route controller responds to request
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
//    @ResponseBody
    public String howOld(
            @PathVariable String username,
            @PathVariable int age,
            Model model
    ){
        model.addAttribute("name", username);
        model.addAttribute("age", age);
        return "happy_birthday"; //Kindof returning what i was looking for
//        return "Happy Birthday, "+username+ " you are now "+age+ " years old.";
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
    @GetMapping("/random/numbers")// added 'path variable'
    public String RandomNumbers(Model model){
        Random r = new Random();
        int low = 1;
        int high = 100;
        int randomNumber= r.nextInt(high-low)+low;
        model.addAttribute("numb", randomNumber);
        return "random";
    }

    @GetMapping("/weather")// added 'path variable'
//    @ResponseBody
    public String viewWeather(Model model){

        String[] weatherInfo = {"Hot", "Humid", "Cloudy", "Hazy", "98F"};
//        model.addAttribute("temp","98F"); // previous
        model.addAttribute("weatherStats", weatherInfo);
        return "WeatherPage";
    }

}
