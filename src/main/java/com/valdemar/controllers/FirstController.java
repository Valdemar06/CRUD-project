package com.valdemar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "surname", required = false) String surname,
                           Model model){
       model.addAttribute("message", "Hello " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(){
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("first_number") int firstNumber,
                             @RequestParam("second_number") int secondNumber,
                             @RequestParam("action") String action, Model model){
        int result;
        switch (action){
            case "multiplication":
                result = firstNumber * secondNumber;
                break;
            case "addition":
                result = firstNumber + secondNumber;
                break;
            case "subtraction":
                result = firstNumber - secondNumber;
                break;
            case "division":
                result = firstNumber/secondNumber;
                break;
            default: result =0;
        }
        String endResult = "Action = "+ action + " Result = " + result;
        model.addAttribute("result", endResult);
        return "first/calculator";
    }
}
