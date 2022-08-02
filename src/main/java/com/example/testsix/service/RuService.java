package com.example.testsix.service;

import com.example.testsix.domain.User;
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

//    @Value("${props.ru.first_name_f}")
//    private static String firstNameF;
//    @Value("${props.ru.first_name_m}")
//    private static String firstNameM;
//    @Value("${props.ru.middle_name_f}")
//    private static String middleNameF;
//    @Value("${props.ru.middle_name_m}")
//    private static String middleNameM;
//    @Value("${props.ru.last_name_f}")
//    private static String lastNameF;
//    @Value("${props.ru.last_name_m}")
//    private static String lastNameM;
//    @Value("${props.ru.addresses}")
//    private static String addressesR;
//    @Value("${props.ru.phone_numbers}")
//    private static String phoneNumbers;

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

    public static void readProps(List<String> props, String path) throws IOException {
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
//        System.out.println(props);
    }

    public static void readAllProps() {
        try {
            readProps(FIRST_NAME_F, "props/ru/first_name_f.txt");
            readProps(FIRST_NAME_M, "props/ru/first_name_m.txt");
            readProps(MIDDLE_NAME_F, "props/ru/middle_name_f.txt");
            readProps(MIDDLE_NAME_M, "props/ru/middle_name_m.txt");
            readProps(LAST_NAME_F, "props/ru/last_name_f.txt");
            readProps(LAST_NAME_M, "props/ru/last_name_m.txt");
            readProps(ADDRESSES, "props/ru/addresses.txt");
            readProps(PHONE_NUMBERS, "props/ru/phone_numbers.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User userGenerator() {
        User user = new User();
        user.setNumber(++id);
        user.setId(UUID.randomUUID().toString());
        if (Math.round(Math.random()) == 0) {
            String username =
                    LAST_NAME_F.get(getRandom(0,49)) +
                    " " +
                    FIRST_NAME_F.get(getRandom(0,49)) +
                    " " +
                    MIDDLE_NAME_F.get(getRandom(0, 49));
            user.setUsername(username);
        } else {
            String username =
                    LAST_NAME_M.get(getRandom(0, 49)) +
                    " " +
                    FIRST_NAME_M.get(getRandom(0, 49)) +
                    " " +
                    MIDDLE_NAME_M.get(getRandom(0, 49));
            user.setUsername(username);
        }
        user.setAddress(ADDRESSES.get(getRandom(0, 49)));
        user.setPhoneNumber(PHONE_NUMBERS.get(getRandom(0, 99)));
        System.out.println(user);
        return user;
    }

    public int getRandom(int origin, int bound){
        return this.random.nextInt(origin,bound);
    }

//    public static void main(String[] args) {
//        readAllProps();
//        RuService ruService = new RuService();
//        ruService.userGenerator();
//    }
}
