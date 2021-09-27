package com.codeup.springblog.models;

import org.springframework.stereotype.Controller;
import javax.persistence.*;


@Entity
@Table(name = "ads")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    //POJO

    public Ad(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Ad(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Ad() {
    }

    public Ad(Long id, String title, String description, User owner) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.owner = owner;
    }


    //getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
