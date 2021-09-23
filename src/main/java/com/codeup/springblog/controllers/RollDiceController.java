package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String rollDice(){
        return "/roll-dice";
    }

    @GetMapping("/roll-dice{n}")
    public String rollDiceGuess(@PathVariable int n, Model model){
        Random rand = new Random();
        int random = rand.nextInt((6-1)+1)+1;// formula = (max-min)+min)+min

        model.addAttribute("diceRoll", random);
        model.addAttribute("userGuess", n);
        //compare the two
        model.addAttribute("isCorrect", random == n);// evaluates to true if true

        return "roll-dice";

    }
}
