package com.qacart.todo.utils;

import com.github.javafaker.Faker;
import com.qacart.todo.apiUser.User;


public class UserUtils {
    public static User generateRandUser() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        User user = new User(firstName, lastName, email, password);
        return user;
    }

}
