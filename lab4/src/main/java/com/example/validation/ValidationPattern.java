package com.example.validation;

public class ValidationPattern {
    public final static String PASSPORT_NUMBER = "^\\d{7}$";
    public final static String PHONE_NUMBER = "^(?:\\\\+375|80)\\\\s?(?:(?:29|33|44|25)\\\\d{7}|(?:17|29|33|44)\\\\d{6})$";
}
