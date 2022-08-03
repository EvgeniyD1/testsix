package com.example.testsix.controller;

import com.example.testsix.domain.User;
import com.example.testsix.service.PropsService;
import com.example.testsix.service.RuService;
import com.example.testsix.service.UaService;
import com.example.testsix.service.UsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RecordController {

    private final RuService ruService;
    private final UaService uaService;
    private final UsService usService;
    private final PropsService propsService;

    public RecordController(RuService ruService,
                            UaService uaService,
                            UsService usService,
                            PropsService propsService) {
        this.ruService = ruService;
        this.uaService = uaService;
        this.usService = usService;
        this.propsService = propsService;
    }

    @GetMapping("/ru")
    public List<User> getRuUsers(@RequestParam(required = false, defaultValue = "0") Integer errors){
        if (PropsService.FIRST_NAME_F_RU.isEmpty()){
            propsService.readRuProps();
        }
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            users.add(ruService.ruUsersGenerator(errors));
        }
        System.out.println(users);
        return users;
    }

    @GetMapping("/ua")
    public List<User> getUaUsers(@RequestParam(required = false, defaultValue = "0") Integer errors){
        if (PropsService.FIRST_NAME_F_UA.isEmpty()){
            propsService.readUaProps();
        }
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            users.add(uaService.uaUsersGenerator(errors));
        }
        return users;
    }

    @GetMapping("/us")
    public List<User> getUsUsers(@RequestParam(required = false, defaultValue = "0") Integer errors){
        if (PropsService.FIRST_NAME_F_US.isEmpty()){
            propsService.readUsProps();
        }
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            users.add(usService.usUsersGenerator(errors));
        }
        return users;
    }
}
