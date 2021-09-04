package com.fortune.demo.service;

import com.fortune.demo.controller.request.PostRequest;
import com.fortune.demo.domain.Post;
import com.fortune.demo.exception.PostException;
import com.fortune.demo.exception.PostExceptionType;
import com.fortune.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> readAllPost() { return postRepository.findAll(); }

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

    public void deletePost(Long postId) {
        try {
            postRepository.deleteById(postId);
        }catch(Exception e){
            throw new PostException(PostExceptionType.NOT_FOUND_POST);
        }
    }

    public Post updatePost(Long postId, PostRequest postRequest) {

        String title = postRequest.getTitle();
        String content = postRequest.getContent();

        try{
            Post post = postRepository.getById(postId);
            post.setTitle(title);
            post.setContent(content);
            return postRepository.save(post);
        }catch(Exception e){
            throw new PostException(PostExceptionType.NOT_FOUND_POST);
        }
    }
}



