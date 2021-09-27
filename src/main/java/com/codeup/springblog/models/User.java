package com.codeup.springblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "owner") //from ad.java --> @ManyToOne private User owner;
    private List<Ad> ads;
}
