package com.fortune.demo.service;

import com.fortune.demo.controller.request.PostRequest;
import com.fortune.demo.domain.Post;
import com.fortune.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post readPost(Long postId) {
        return postRepository.findById(postId).orElseThrow(NullPointerException::new);
    }

    public Post writePost(PostRequest postRequest) {
        String title = postRequest.getTitle();
        String content = postRequest.getContent();

        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);

        return postRepository.save(post);
    }

    public String deletePost(Long postId) {
        String retstr = "Delete Fail";
        if (postRepository.existsById(postId)) {
            postRepository.deleteById(postId);
            retstr = "Delete : " + postId;
        }
        return retstr;
    }
}
