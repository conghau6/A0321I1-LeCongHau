package com.codegym.blog.ultil;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String passwordEncode = encoder.encode("123456");
        System.out.println(passwordEncode);
    }
}
