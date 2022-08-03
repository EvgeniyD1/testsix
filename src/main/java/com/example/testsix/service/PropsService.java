package com.example.testsix.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PropsService {

    @Value("${props.ru.first_name_f}")
    private String firstNameFRu;
    @Value("${props.ru.first_name_m}")
    private String firstNameMRu;
    @Value("${props.ru.middle_name_f}")
    private String middleNameFRu;
    @Value("${props.ru.middle_name_m}")
    private String middleNameMRu;
    @Value("${props.ru.last_name_f}")
    private String lastNameFRu;
    @Value("${props.ru.last_name_m}")
    private String lastNameMRu;
    @Value("${props.ru.addresses}")
    private String addressesSRu;
    @Value("${props.ru.phone_numbers}")
    private String phoneNumbersRu;

    @Value("${props.ua.first_name_f}")
    private String firstNameFUa;
    @Value("${props.ua.first_name_m}")
    private String firstNameMUa;
    @Value("${props.ua.middle_name_f}")
    private String middleNameFUa;
    @Value("${props.ua.middle_name_m}")
    private String middleNameMUa;
    @Value("${props.ua.last_name_f}")
    private String lastNameFUa;
    @Value("${props.ua.last_name_m}")
    private String lastNameMUa;
    @Value("${props.ua.addresses}")
    private String addressesSUa;
    @Value("${props.ua.phone_numbers}")
    private String phoneNumbersUa;

    @Value("${props.us.first_name_f}")
    private String firstNameFUs;
    @Value("${props.us.first_name_m}")
    private String firstNameMUs;
    @Value("${props.us.last_name_f}")
    private String lastNameFUs;
    @Value("${props.us.last_name_m}")
    private String lastNameMUs;
    @Value("${props.us.addresses}")
    private String addressesSUs;
    @Value("${props.us.phone_numbers}")
    private String phoneNumbersUs;

    public static final List<String> FIRST_NAME_F_RU = new ArrayList<>();
    public static final List<String> FIRST_NAME_M_RU = new ArrayList<>();
    public static final List<String> MIDDLE_NAME_F_RU = new ArrayList<>();
    public static final List<String> MIDDLE_NAME_M_RU = new ArrayList<>();
    public static final List<String> LAST_NAME_F_RU = new ArrayList<>();
    public static final List<String> LAST_NAME_M_RU = new ArrayList<>();
    public static final List<String> ADDRESSES_RU = new ArrayList<>();
    public static final List<String> PHONE_NUMBERS_RU = new ArrayList<>();

    public static final List<String> FIRST_NAME_F_UA = new ArrayList<>();
    public static final List<String> FIRST_NAME_M_UA = new ArrayList<>();
    public static final List<String> MIDDLE_NAME_F_UA = new ArrayList<>();
    public static final List<String> MIDDLE_NAME_M_UA = new ArrayList<>();
    public static final List<String> LAST_NAME_F_UA = new ArrayList<>();
    public static final List<String> LAST_NAME_M_UA = new ArrayList<>();
    public static final List<String> ADDRESSES_UA = new ArrayList<>();
    public static final List<String> PHONE_NUMBERS_UA = new ArrayList<>();

    public static final List<String> FIRST_NAME_F_US = new ArrayList<>();
    public static final List<String> FIRST_NAME_M_US = new ArrayList<>();
    public static final List<String> LAST_NAME_F_US = new ArrayList<>();
    public static final List<String> LAST_NAME_M_US = new ArrayList<>();
    public static final List<String> ADDRESSES_US = new ArrayList<>();
    public static final List<String> PHONE_NUMBERS_US = new ArrayList<>();

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

    public void readRuProps() {
        try {
            readProps(FIRST_NAME_F_RU, firstNameFRu);
            readProps(FIRST_NAME_M_RU, firstNameMRu);
            readProps(MIDDLE_NAME_F_RU, middleNameFRu);
            readProps(MIDDLE_NAME_M_RU, middleNameMRu);
            readProps(LAST_NAME_F_RU, lastNameFRu);
            readProps(LAST_NAME_M_RU, lastNameMRu);
            readProps(ADDRESSES_RU, addressesSRu);
            readProps(PHONE_NUMBERS_RU, phoneNumbersRu);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readUaProps() {
        try {
            readProps(FIRST_NAME_F_UA, firstNameFUa);
            readProps(FIRST_NAME_M_UA, firstNameMUa);
            readProps(MIDDLE_NAME_F_UA, middleNameFUa);
            readProps(MIDDLE_NAME_M_UA, middleNameMUa);
            readProps(LAST_NAME_F_UA, lastNameFUa);
            readProps(LAST_NAME_M_UA, lastNameMUa);
            readProps(ADDRESSES_UA, addressesSUa);
            readProps(PHONE_NUMBERS_UA, phoneNumbersUa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readUsProps() {
        try {
            readProps(FIRST_NAME_F_US, firstNameFUs);
            readProps(FIRST_NAME_M_US, firstNameMUs);
            readProps(LAST_NAME_F_US, lastNameFUs);
            readProps(LAST_NAME_M_US, lastNameMUs);
            readProps(ADDRESSES_US, addressesSUs);
            readProps(PHONE_NUMBERS_US, phoneNumbersUs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
