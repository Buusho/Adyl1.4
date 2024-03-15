package src.service;

import model.Post;

import java.util.List;

public interface PostService {
    String addPostToUser(Post post);
    String deletePostById(Long postId);
    List<Post> getPostsByUserId(Long userId);
}
