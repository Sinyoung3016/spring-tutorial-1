package com.fortune.demo.controller;


import com.fortune.demo.controller.request.PostRequest;
import com.fortune.demo.domain.Post;
import com.fortune.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("post/{id}")
    public Post readPost(@PathVariable Long id){
        return postService.readPost(id);
    }

    @PostMapping("post")
    public Post readPost(@RequestBody PostRequest postRequest) {
        return postService.writePost(postRequest);
    }
}
