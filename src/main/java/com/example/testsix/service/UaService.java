package com.example.testsix.service;

import com.example.testsix.domain.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UaService {

    @Getter
    @Setter
    private Long id = 0L;

    private final MainService mainService;

    public UaService(MainService mainService) {
        this.mainService = mainService;
    }

    /*generate ua user with errors errors*/
    public User uaUsersGenerator(int errors) {
        User user = new User();
        user.setNumber(++id);
        user.setId(UUID.randomUUID().toString());
        if (Math.round(Math.random()) == 0) {
            String username = mainService.usernameGenerator(PropsService.LAST_NAME_F_UA,
                    PropsService.FIRST_NAME_F_UA,
                    PropsService.MIDDLE_NAME_F_UA);
            user.setUsername(username);
        } else {
            String username = mainService.usernameGenerator(PropsService.LAST_NAME_M_UA,
                    PropsService.FIRST_NAME_M_UA,
                    PropsService.MIDDLE_NAME_M_UA);
            user.setUsername(username);
        }
        user.setAddress(PropsService.ADDRESSES_UA.get(mainService.getRandom100()));
        user.setPhoneNumber(PropsService.PHONE_NUMBERS_UA.get(mainService.getRandom100()));
        return mainService.errorRecord(user, errors);
    }

}
