
package com.mo.inmemoryloginauthentication.controller;

import com.mo.inmemoryloginauthentication.model.Post;
import com.mo.inmemoryloginauthentication.repo.PostRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepo posts;

    public PostController(PostRepo posts) {
        this.posts = posts;
    }

    @GetMapping()
    public Iterable<Post> findAll(){
        return posts.findAll();
    }

    @GetMapping("/{id}")
    public Post findById (@PathVariable ("id") Post post){
        return post;
    }
}

