package com.example.testsix.controller;

import com.example.testsix.service.PropsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final PropsService propsService;

    public MainController(PropsService propsService) {
        this.propsService = propsService;
    }

    @GetMapping
    public String main(){
        if (PropsService.FIRST_NAME_F_RU.isEmpty()){
            propsService.readRuProps();
        }
        if (PropsService.FIRST_NAME_F_UA.isEmpty()){
            propsService.readUaProps();
        }
        if (PropsService.FIRST_NAME_F_US.isEmpty()){
            propsService.readUsProps();
        }
        return "index";
    }
}
