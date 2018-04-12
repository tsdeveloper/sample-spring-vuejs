package com.tsdeveloper.github.samplespringvuejs.controllers;

import com.tsdeveloper.github.samplespringvuejs.entities.Post;
import com.tsdeveloper.github.samplespringvuejs.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/")
    public  String index(){

        return "index";
    }

    @GetMapping(value = "/posts")
    public List<Post> posts(){
        return postService.getAllPost();
    }

    @PostMapping(value = "/post")
    public void publishPost(@RequestBody Post post){

        if(post.getCreated() == null)
            post.setCreated(new Date());
        postService.insert(post);
    }

}
