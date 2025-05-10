package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController // HTTP 요청 받는 역할
public class HelloController {

    private final PostService postService; // final : 한번 초기화된 이후 다시 바꿀 수 없음

    public HelloController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/posts")
    public String writeMultiplePosts(@RequestBody List<Post> posts) {
        postService.saveAll(posts);
        return "총 " + posts.size() + "개의 글 저장 완료";
    }

    @GetMapping("/posts") // 전체 글 리스트 조회
    public List<Post> readPosts() {
        return postService.findAll();
    }

}
