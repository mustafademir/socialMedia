package com.scorp.socialmedia.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "posts")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(nullable = false)
    protected Date created;

    @Column
    private String description;

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }
}
