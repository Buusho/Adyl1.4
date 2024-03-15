package src;

import model.DataBase;
import model.Post;
import service.PostService;
import service.UserService;
import service.serviceImpl.PostServiceImpl;
import service.serviceImpl.UserServiceImpl;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
//        LinkedList<Integer> linkedList2 = new LinkedList<>();
//      LinkedList<Integer> linkedList3 = new LinkedList<>();
//
//        LinkedList <Integer> linkedList = new LinkedList<>();
//        linkedList.add(12);
//        linkedList.add(13);
//        linkedList.add(14);
//        linkedList.add(15);
//        linkedList.add(16);
//        linkedList.add(17);
//        System.out.println(linkedList);

//        for (Integer integer : linkedList) {
//            if (integer % 2 == 0) {
//                linkedList2.add(integer);
//            } else {
//                linkedList3.add(integer);
//            }
//        }
//        for (int i = 0; i < linkedList.size(); i++) {
//            Integer integer = linkedList.get(i);
//            if (integer % 2 == 0) {
//                linkedList2.add(integer);
//            } else {
//                linkedList3.add(integer);
//            }
//        }
//
//        Iterator<Integer> iterator = linkedList.iterator();
//        while (iterator.hasNext()) {
//            Integer integer = iterator.next();
//            if (integer % 2 == 0) {
//                linkedList2.add(integer);
//            } else {
//                linkedList3.add(integer);
//            }
//        }
//        System.out.println("Even numbers: " + linkedList2);
//        System.out.println("Odd numbers: " + linkedList3);
        UserService user = new UserServiceImpl();
        PostService postService = new PostServiceImpl();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите операцию:");
            System.out.println("1.Register");
            System.out.println("2.Login");
            System.out.println("3.Get user ");
            System.out.println("4.Get all users");
            System.out.println("5.Add post");
            System.out.println("6.Delete post");
            System.out.println("7.Get all posts ");
            int a = sc.nextInt();
            switch (a) {
                case 1 -> {
                    System.out.println("Register:");
                    System.out.println(user.register());
                }
                case 2 -> {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Email:");
                    String email = scanner.nextLine();
                    System.out.println("Password:");
                    String password = scanner.nextLine();
                    System.out.println(user.login(email, password));
                }
                case 3 -> {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Email:");
                    System.out.println(user.getUserByEmail(scanner.nextLine()));
                }
                case 4 ->{
                    System.out.println("User id :");
                    System.out.println(user.getAllUsers());
                }

                case 5 -> {
                    if (!DataBase.users.isEmpty()) {
                        System.out.println("Add post:");
                        postService.addPostToUser(new Post());
                    }
                    else {
                        System.out.println("create a user!");
                    }
                }
                case 6 -> {
                    if (!DataBase.posts.isEmpty()) {
                        System.out.println("Delete post by post Id:");
                        postService.deletePostById(new Scanner(System.in).nextLong());
                    }
                    else {
                        System.out.println("create a post!");
                    }
                }
                case 7 ->{
                    if (!DataBase.posts.isEmpty()) {
                        System.out.println("Id:");
                        postService.getPostsByUserId(new Scanner(System.in).nextLong());
                    }
                    else {
                        System.out.println("create a post!");
                    }
                }


            }


        }


    }
}