package com.example.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(ModelMap modelMap) {

        modelMap.addAttribute("userName", "chris");

        return "index";
    }
}
