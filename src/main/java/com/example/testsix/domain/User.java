package com.example.testsix.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private Long number;
    private String id;
    private String username;
    private String phoneNumber;
    private String address;

}
