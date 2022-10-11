package ru.netology.data;

import lombok.Value;

public class DataHelper {

    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    @Value
    public static class CardBank {
        private String numberCard;
    }

    public static AuthInfo getAuthInfo() {


        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getOtherAuthInfo(AuthInfo original) {


        return new AuthInfo("petya", "123qwerty");
    }

    public static CardBank getFirstCardBank() {

        return new CardBank("5559 0000 0000 0001");
    }

    public static CardBank getSecondCardBank() {

        return new CardBank("5559 0000 0000 0002");
    }

    @Value
    public static class VerificationCode {

        private String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {

        return new VerificationCode("12345");
    }
}
