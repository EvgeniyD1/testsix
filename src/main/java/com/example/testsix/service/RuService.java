package com.example.testsix.service;

import com.example.testsix.domain.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RuService {

    @Getter
    @Setter
    private Long id = 0L;

    private final MainService mainService;

    public RuService(MainService mainService) {
        this.mainService = mainService;
    }

    /*generate ru user with errors errors*/
    public User ruUsersGenerator(int errors) {
        User user = new User();
        user.setNumber(++id);
        user.setId(UUID.randomUUID().toString());
        if (Math.round(Math.random()) == 0) {
            String username = mainService.usernameGenerator(PropsService.LAST_NAME_F_RU,
                    PropsService.FIRST_NAME_F_RU,
                    PropsService.MIDDLE_NAME_F_RU);
            user.setUsername(username);
        } else {
            String username = mainService.usernameGenerator(PropsService.LAST_NAME_M_RU,
                    PropsService.FIRST_NAME_M_RU,
                    PropsService.MIDDLE_NAME_M_RU);
            user.setUsername(username);
        }
        user.setAddress(PropsService.ADDRESSES_RU.get(mainService.getRandom100()));
        user.setPhoneNumber(PropsService.PHONE_NUMBERS_RU.get(mainService.getRandom100()));
        return mainService.errorRecord(user, errors);
    }

}
