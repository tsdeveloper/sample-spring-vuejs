package com.tsdeveloper.github.samplespringvuejs.repositories;

import com.tsdeveloper.github.samplespringvuejs.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository  extends JpaRepository<Post,Long>{


}
