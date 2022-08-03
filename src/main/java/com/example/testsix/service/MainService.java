package com.example.testsix.service;

import com.example.testsix.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class MainService {

    private final Random random = new Random();

    /*generate username*/
    public String usernameGenerator(List<String> lastName, List<String> firstName, List<String> middleName) {
        return lastName.get(getRandom100()) + " " + firstName.get(getRandom100()) + " " + middleName.get(getRandom100());
    }

    /*generate americans names*/
    public String usUsernameGenerator(List<String> firstName, List<String> lastName) {
        return firstName.get(getRandom100()) + " " + lastName.get(getRandom100());
    }

    public int getRandom(int origin, int bound) {
        return this.random.nextInt(origin, bound);
    }

    public int getRandom100() {
        return getRandom(0, 99);
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
