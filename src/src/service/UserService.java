package src.service;

import model.User;

import java.util.List;

public interface UserService {
    String register ();
    String login(String email,String password);
    User getUserByEmail(String email);
    List<User> getAllUsers();
}
