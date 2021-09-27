package com.codeup.springblog.repos;

import models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRespository extends JpaRepository<Post, Long> {

}


