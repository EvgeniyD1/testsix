package com.example.testsix.service;

import com.example.testsix.domain.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsService {

    @Getter
    @Setter
    private Long id = 0L;

    private final MainService mainService;

    public UsService(MainService mainService) {
        this.mainService = mainService;
    }

    /*generate us user with errors errors*/
    public User usUsersGenerator(int errors) {
        User user = new User();
        user.setNumber(++id);
        user.setId(UUID.randomUUID().toString());
        if (Math.round(Math.random()) == 0) {
            String username = mainService.usUsernameGenerator(PropsService.FIRST_NAME_F_US,
                    PropsService.LAST_NAME_F_US);
            user.setUsername(username);
        } else {
            String username = mainService.usUsernameGenerator(PropsService.FIRST_NAME_M_US,
                    PropsService.LAST_NAME_M_US);
            user.setUsername(username);
        }
        user.setAddress(PropsService.ADDRESSES_US.get(mainService.getRandom100()));
        user.setPhoneNumber(PropsService.PHONE_NUMBERS_US.get(mainService.getRandom100()));
        return mainService.errorRecord(user, errors);
    }
}
