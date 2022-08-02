package com.example.testsix.controller;

import com.example.testsix.domain.User;
import com.example.testsix.service.RuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    private final RuService ruService;

    public MainController(RuService ruService) {
        this.ruService = ruService;
    }

    @GetMapping
    public List<User> getUser(){
        if (RuService.FIRST_NAME_F.isEmpty()){
            ruService.readAllProps();
        }
//        RuService.id = 0L;
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            users.add(ruService.userGenerator());
        }
        return users;
    }
}
