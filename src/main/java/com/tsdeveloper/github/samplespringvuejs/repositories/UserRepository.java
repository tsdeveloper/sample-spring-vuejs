package com.tsdeveloper.github.samplespringvuejs.repositories;

import com.tsdeveloper.github.samplespringvuejs.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByUserName(String userName);
}
