package com.fortune.demo.controller;

import com.fortune.demo.controller.request.PostRequest;
import com.fortune.demo.domain.Post;
import com.fortune.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("post")
    public List<Post> readAllPost(){
        return postService.readAllPost();
    }

    @GetMapping("post/{id}")
    public Post readPost(@PathVariable Long id){ return postService.readPost(id); }

    @PostMapping("write")
    public Post writePost(@RequestBody PostRequest postRequest) {
        return postService.writePost(postRequest);
    }

    @DeleteMapping("delete/{id}")
    public String deletePost(@PathVariable Long id) { return postService.deletePost(id);}

    @PostMapping("update/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody PostRequest postRequest){return postService.updatePost(id, postRequest);}

}

