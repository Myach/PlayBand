package com.playband.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class A {
    /**
     * @param args
     */
    public static void main(String[] args) {
        String password = "qwerty12345";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode(password));
    }
}
