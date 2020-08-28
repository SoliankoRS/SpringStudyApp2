package ru.solianko.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        System.out.println("Hello, " + name + " " + surname + "!");
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(@RequestParam("name") String name,
                              @RequestParam(value = "surname", required = false) String surname,
                              Model model) {
//        System.out.println("Hello, " + name + " " + surname + "!");
        model.addAttribute("message", "Hello, " + name + " " + surname + "!");
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam("a") double a,
                                 @RequestParam("b") double b,
                                 @RequestParam("action") String action,
                                 Model model) {
        double result;
        switch (action) {
            case "addition":
                result = a + b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "multiplication":
                result = a * b;
                break;
            case "division":
                result = a / b;
                break;
            default:
                result = 0D;
                break;
        }
        model.addAttribute("calculatorResult", result);
        return "first/calculator";
    }
}
