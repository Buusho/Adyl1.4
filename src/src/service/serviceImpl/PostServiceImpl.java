package src.service.serviceImpl;

import model.DataBase;
import model.GenerateId;
import model.Post;
import model.User;
import service.PostService;

import java.util.List;
import java.util.Scanner;

public class PostServiceImpl implements PostService {

    @Override
    public String addPostToUser(Post post) {
        post.setId(GenerateId.genPostId());
        System.out.println("image:");
        post.setImageUrl(new Scanner(System.in).next());
        System.out.println("description:");
        post.setDescription(new Scanner(System.in).next());
        DataBase.posts.add(post);
        return "Success added!";
    }

    @Override
    public String deletePostById(Long postId) {
        for (Post post :DataBase.posts
             ) {
            if(post.getId().equals(postId)){
                DataBase.posts.remove(post);
                System.out.println("Post deleted :)");
            }
        }

        return "Post with " + postId+ "not deleted" ;
    }

    @Override
    public List<Post> getPostsByUserId(Long userId) {
        for (User user:DataBase.users
             ) {
            if(user.getId().equals(userId)){
                System.out.println("Post with userId"+userId+"founded");
                return user.getPosts();
            }
            else {
                System.out.println("Post with userId"+userId+" not founded !!");
            }
        }

        return null;
    }
}
