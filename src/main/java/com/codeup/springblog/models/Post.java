package com.codeup.springblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, length = 50)
        private String title;

        @Column(nullable = false, columnDefinition = "TEXT")
        private String body;
//        @Column(nullable = false, columnDefinition = "TEXT")
//        private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")//column that holds foreign key on post,
    private User owner;

//    Post postToUpDate = postDao.getById(id);
    //POJO, plain old java object, no db associated

//    private Long id;
//
//    private String title;
//    private String body;

    public Post() {
    }

    public Post(String title, String body, User owner) {
        this.title = title;
        this.body = body;
        this.owner = owner;
    }

    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

//    public Post(String title, String body, String description) {
//        this.title = title;
//        this.body = body;
//        this.description = description;
//    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    //    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }


}
