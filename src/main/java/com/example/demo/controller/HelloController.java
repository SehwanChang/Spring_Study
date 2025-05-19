package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller// HTTP 요청 받는 역할
public class HelloController {

    private final PostService postService; // final : 한번 초기화된 이후 다시 바꿀 수 없음

    public HelloController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/posts/json")
    public String writeMultiplePosts(@RequestBody List<Post> posts) {
        postService.saveAll(posts);
        return "총 " + posts.size() + "개의 글 저장 완료";
    }

    @PostMapping("/posts")
    public String savePost(Post post){
        postService.save(post);
        return "redirect:/posts-view";

    }


    @GetMapping("/posts") // 전체 글 리스트 조회
    public List<Post> readPosts() {
        return postService.findAll();
    }
    @GetMapping("/posts-view")
    public String showPostList (Model model) {
        List<Post> posts = postService.findAll();
        model.addAttribute("posts", posts);
        return "post-list";
    }

    @GetMapping("/posts/new")
    public String showPostForm(){
        return "post-form";
    }
}
