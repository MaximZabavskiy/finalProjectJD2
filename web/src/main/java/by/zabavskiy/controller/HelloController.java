package by.zabavskiy.controller;

import by.zabavskiy.aspect.LoggingAspect;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/hello")
    public String hello(ModelMap modelMap) {
        modelMap.addAttribute("stat", LoggingAspect.showStatistics());

        return "hello";
    }
}
