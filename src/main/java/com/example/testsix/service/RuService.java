package com.example.testsix.service;

import com.example.testsix.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class RuService {

    @Value("${props.ru.first_name_f}")
    private String firstNameF;
    @Value("${props.ru.first_name_m}")
    private String firstNameM;
    @Value("${props.ru.middle_name_f}")
    private String middleNameF;
    @Value("${props.ru.middle_name_m}")
    private String middleNameM;
    @Value("${props.ru.last_name_f}")
    private String lastNameF;
    @Value("${props.ru.last_name_m}")
    private String lastNameM;
    @Value("${props.ru.addresses}")
    private String addressesR;
    @Value("${props.ru.phone_numbers}")
    private String phoneNumbers;

    public static final List<String> FIRST_NAME_F = new ArrayList<>();
    public static final List<String> FIRST_NAME_M = new ArrayList<>();
    public static final List<String> MIDDLE_NAME_F = new ArrayList<>();
    public static final List<String> MIDDLE_NAME_M = new ArrayList<>();
    public static final List<String> LAST_NAME_F = new ArrayList<>();
    public static final List<String> LAST_NAME_M = new ArrayList<>();
    public static final List<String> ADDRESSES = new ArrayList<>();
    public static final List<String> PHONE_NUMBERS = new ArrayList<>();

    public static Long id = 0L;
    Random random = new Random();

    /*read props from path*/
    public void readProps(List<String> props, String path) throws IOException {
        ClassPathResource res = new ClassPathResource(path);
        File file = new File(res.getURI().getPath());
        String line;
        try (BufferedReader brr = new BufferedReader(new FileReader(file))) {
            while ((line = brr.readLine()) != null) {
                props.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*read all*/
    public void readAllProps() {
        try {
            readProps(FIRST_NAME_F, firstNameF);
            readProps(FIRST_NAME_M, firstNameM);
            readProps(MIDDLE_NAME_F, middleNameF);
            readProps(MIDDLE_NAME_M, middleNameM);
            readProps(LAST_NAME_F, lastNameF);
            readProps(LAST_NAME_M, lastNameM);
            readProps(ADDRESSES, addressesR);
            readProps(PHONE_NUMBERS, phoneNumbers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*generate user with errors errors*/
    public User userGenerator(int errors) {
        User user = new User();
        user.setNumber(++id);
        user.setId(UUID.randomUUID().toString());
        if (Math.round(Math.random()) == 0) {
            String username = usernameGenerator(LAST_NAME_F, FIRST_NAME_F, MIDDLE_NAME_F);
            user.setUsername(username);
        } else {
            String username = usernameGenerator(LAST_NAME_M, FIRST_NAME_M, MIDDLE_NAME_M);
            user.setUsername(username);
        }
        user.setAddress(ADDRESSES.get(getRandom100()));
        user.setPhoneNumber(PHONE_NUMBERS.get(getRandom100()));
        return errorRecord(user, errors);
    }

    /*generate username*/
    public String usernameGenerator(List<String> lastName, List<String> firstName, List<String> middleName) {
        return lastName.get(getRandom100()) + " " + firstName.get(getRandom100()) + " " + middleName.get(getRandom100());
    }

    /*make err errors in record*/
    public User errorRecord(User user, int err) {
        for (int i = 0; i < err; i++) {
            int rnd = getRandom(0, 3);
            switch (rnd) {
                case 0 -> user.setUsername(makeSomeError(user.getUsername()));
                case 1 -> user.setAddress(makeSomeError(user.getAddress()));
                case 2 -> user.setPhoneNumber(makeSomeError(user.getPhoneNumber()));
                default -> System.out.println("some error");
            }
        }
        return user;
    }

    public int getRandom(int origin, int bound) {
        return this.random.nextInt(origin, bound);
    }

    public int getRandom100() {
        return getRandom(0, 99);
    }

    /*add one char in some position*/
    public String addOneChar(String value) {
        StringBuilder sb = new StringBuilder(value);
        int replacedOne = getRandom(0, sb.length() - 1);
        int replacedTwo = getRandom(0, value.length() - 1);
        sb.setCharAt(replacedOne, sb.charAt(replacedTwo));
        return sb.toString();
    }

    /*delete one char from string*/
    public String deleteOneChar(String value) {
        StringBuilder sb = new StringBuilder(value);
        int delOne = getRandom(0, sb.length() - 1);
        sb.delete(delOne, delOne + 1);
        return sb.toString();
    }

    /*swap two chars*/
    public String swapChars(String value) {
        int replacedOne = getRandom(0, value.length() - 1);
        int replacedTwo;
        if (replacedOne < value.length() - 1) {
            replacedTwo = replacedOne + 1;
        } else {
            replacedTwo = replacedOne - 1;
        }
        return value.replace(value.charAt(replacedOne), value.charAt(replacedTwo));
    }

    /*make one random error*/
    public String makeSomeError(String value) {
        int rnd = getRandom(0, 3);
        switch (rnd) {
            case 0:
                return addOneChar(value);
            case 1:
                return deleteOneChar(value);
            case 2:
                return swapChars(value);
            default:
                System.out.println("some error");
        }
        return value;
    }

}
