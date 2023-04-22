package com.example.recovery.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordEncoderUtilTest {

    @Test
    void generatePassword() {
        String re2023 = PasswordEncoderUtil.generatePassword("re2023", "1a767866321d4df8");
        System.out.println(re2023);
    }
}