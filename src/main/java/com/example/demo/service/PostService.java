package com.example.demo.service;

import com.example.demo.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class PostService {
    private final List<Post> posts = new ArrayList<>();

    public void saveAll(List<Post> newPosts){
        posts.clear();
        posts.addAll(newPosts);
    }

    public List<Post> findAll(){
        return posts;
    }

    public void save(Post post){
        posts.add(post);
    }
}
