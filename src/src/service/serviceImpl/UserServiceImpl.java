package src.service.serviceImpl;

import enums.Gender;
import model.DataBase;
import model.GenerateId;
import model.User;
import service.UserService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserServiceImpl implements UserService {
//    @Override
//    public String register() {
//        User user = new User();
//        DataBase.users.add(user);
//        return null;
//    }


    @Override
    public String register() {
        User user = new User();
        user.setId(GenerateId.genUserId());
        System.out.println("Full name :");
        user.setFullName(new Scanner(System.in).nextLine());
        System.out.println("Email :");
        user.setEmail(new Scanner(System.in).nextLine());
        System.out.println("Password :");
        user.setPassword(new Scanner(System.in).nextLine());
        System.out.println("Gender :");
        System.out.println(user.getGender(Gender.MALE));
        DataBase.users.add(user);
        return "Users registered successfully";
    }

    @Override
    public String login(String email, String password) {
        for (User user : DataBase.users
        ) {
            if (  user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return "Login successful";
            }
        }

        return "Login failed: Invalid email or password";
    }

    @Override
    public User getUserByEmail(String email) {
        for (User user : DataBase.users
        ) {
            if (user.getEmail().equals(email)) {
                System.out.println("user with" + email + "founded");
               return user;
            }
        }

        throw new NoSuchElementException("User with email " + email + " not found") ;
    }

    @Override
    public List<User> getAllUsers() {

        return DataBase.users;
    }
}
