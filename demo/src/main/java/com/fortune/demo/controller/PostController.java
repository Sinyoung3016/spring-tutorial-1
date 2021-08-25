package com.fortune.demo.controller;

import com.fortune.demo.controller.request.PostRequest;
import com.fortune.demo.domain.Post;
import com.fortune.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("posts")
    public List<Post> readAllPost(){
        return postService.readAllPost();
    }

    @GetMapping("post/{id}")
    public Post readPost(@PathVariable Long id){ return postService.readPost(id); }

    @PostMapping("post")
    public Post writePost(@RequestBody PostRequest postRequest) {return postService.writePost(postRequest); }

    @DeleteMapping("delete/{id}")
    public void deletePost(@PathVariable Long id) { postService.deletePost(id); }

    @PostMapping("update/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody PostRequest postRequest){return postService.updatePost(id, postRequest);}

}

