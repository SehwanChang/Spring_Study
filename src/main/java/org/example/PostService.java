package org.example;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class PostService {
    private final List<Post> postList = new ArrayList<>();

    public void saveAll(List<Post> posts){
        postList.clear();
        postList.addAll(posts);
    }

    public List<Post> findAll(){
        return postList;
    }
}
