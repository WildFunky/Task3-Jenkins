package com.example.l2task3.utils;

import org.apache.commons.lang.RandomStringUtils;

import java.util.Random;

public class RandomUtils {

    private static final String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final Random random = new Random();

    private static String getRandomBasePassword(int stringLength) {
        return RandomStringUtils.randomAlphanumeric(stringLength);
    }

    private static char getRandomChar(String str) {
        int randomIndex = random.nextInt(str.length());
        return str.charAt(randomIndex);
    }

    public static String getRandomString(String stringLength) {
        int length = Integer.parseInt(stringLength);
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static String generatePassword(String email, String passwordLength) {
        int length = Integer.parseInt(passwordLength);
        StringBuilder base = new StringBuilder().append(getRandomBasePassword(length - 2));
        char randomCyrillicChar = getRandomChar(alphabet);
        base.insert(random.nextInt(base.length()), randomCyrillicChar);
        char randomCharFromEmail = getRandomChar(email);
        base.insert(random.nextInt(base.length()), randomCharFromEmail);
        return base.toString();
    }
}
