package com.example.thymeleaf;

import com.example.thymeleaf.model.UserVo;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@RestController
@RequestMapping("/")
public class LoginController {

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(ModelAndView modelAndView, @Valid UserVo userVo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            modelAndView.addObject("error",bindingResult.getFieldError().getDefaultMessage());
            modelAndView.setViewName("login");
            return modelAndView;
        }
        String userName = userVo.getUserName();
        String password = userVo.getPassword();

        if(!"admin".equals(userName)){
            modelAndView.addObject("error","无此用户！");
            modelAndView.setViewName("login");
            return modelAndView;
        }
        if(!"123456".equals(password)){
            modelAndView.addObject("error","密码错误！");
            modelAndView.setViewName("login");
            return modelAndView;
        }
        modelAndView.addObject("userName",userName);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}