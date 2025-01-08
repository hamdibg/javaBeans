package com.javabeans.main;

import com.javabeans.javabeans.UserBean;
import com.javabeans.service.UserService;

public class Main {
    public static void main(String[] args) {
        try {
            UserService userService = new UserService();

            UserBean user1 = new UserBean();
            user1.setFirstName("Hamdi");
            user1.setLastName("BG");
            user1.setEmail("Hamdi.BG@sesame.com");
            userService.addUser(user1);

            UserBean user2 = new UserBean();
            user2.setFirstName("Fatma");
            user2.setLastName("BS");
            user2.setEmail("Fatma.BS@sesame.com");
            userService.addUser(user2);

            userService.displayUsers();

            UserBean invalidUser = new UserBean();
            invalidUser.setFirstName("");
            userService.addUser(invalidUser);

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}