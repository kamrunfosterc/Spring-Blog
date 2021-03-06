package com.codeup.springblog.repos;

import com.codeup.springblog.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdRepository extends JpaRepository<Ad, Long> {

    Ad getByDescription(String description);// property should match lhs, uses java reflections

}




