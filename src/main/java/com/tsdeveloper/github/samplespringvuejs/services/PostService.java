package com.tsdeveloper.github.samplespringvuejs.services;

import com.tsdeveloper.github.samplespringvuejs.entities.Post;
import com.tsdeveloper.github.samplespringvuejs.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    public void insert(Post post) {
        postRepository.save(post);
    }
}
