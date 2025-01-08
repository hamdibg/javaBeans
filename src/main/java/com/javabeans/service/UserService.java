package com.javabeans.service;

import com.javabeans.javabeans.UserBean;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static final List<UserBean> users = new ArrayList<>();

    public void addUser(UserBean user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        boolean emailExists = users.stream()
                .anyMatch(u -> u.getEmail().equalsIgnoreCase(user.getEmail()));

        if (emailExists) {
            throw new IllegalArgumentException("Email already exists: " + user.getEmail());
        }

        users.add(user);
        System.out.println("User added successfully: " + user.getFirstName() + " " + user.getLastName());
    }

    public void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }

        System.out.println("\n=== List of Users ===");
        for (int i = 0; i < users.size(); i++) {
            UserBean user = users.get(i);
            System.out.println("\nUser #" + (i + 1));
            System.out.println("First Name: " + user.getFirstName());
            System.out.println("Last Name: " + user.getLastName());
            System.out.println("Email: " + user.getEmail());
            System.out.println("------------------");
        }
        System.out.println("\nTotal users: " + users.size());
    }
}