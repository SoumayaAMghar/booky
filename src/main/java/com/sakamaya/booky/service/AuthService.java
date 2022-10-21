package com.sakamaya.booky.service;

import com.sakamaya.booky.dao.UserDAO;
import com.sakamaya.booky.model.User;
import com.sakamaya.booky.model.enums.UserRoles;
import io.github.cdimascio.dotenv.Dotenv;

public class AuthService {
    private static AuthService instance = null;
    private static final Dotenv dotenv;
    private User currentUser = null;
    private UserDAO userDAO;

    static {
        dotenv = Dotenv.load();
    }

    private AuthService() {
    }

    public static AuthService getInstance() {
        if (instance == null) {
            instance = new AuthService();
        }
        return instance;
    }

    public void setDAOs(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean login(String username, String password) {
        User user = userDAO.findByUsername(username);
        if (user != null && decryptPassword(user.getPassword()).equals(password)) {
            currentUser = user;
            return true;
        }
        return false;
    }

    public boolean register(String username, String password, String cin, String name) {
        User user = new User(username, encryptPassword(password), cin, name, UserRoles.USER);
        return userDAO.save(user);
    }

    private String encryptPassword(String password) {
        StringBuilder encryptedPassword = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            encryptedPassword.append((char) (password.charAt(i) + Integer.parseInt(dotenv.get("PASSWORD_ENCRYPTION_MAGIC_NUMBER"))));
        }
        return encryptedPassword.toString();
    }

    private String decryptPassword(String password) {
        StringBuilder decryptedPassword = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            decryptedPassword.append((char) (password.charAt(i) - Integer.parseInt(dotenv.get("PASSWORD_ENCRYPTION_MAGIC_NUMBER"))));
        }
        return decryptedPassword.toString();
    }

    public void logout() {
        currentUser = null;
    }
}
