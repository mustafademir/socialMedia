package com.scorp.socialmedia.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "posts")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;

    @Column(nullable = false)
    protected Date created;

    @Column
    private String description;

    @Transient
    private boolean liked;

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return liked == post.liked && Objects.equals(id, post.id) && Objects.equals(created, post.created) && Objects.equals(description, post.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, created, description, liked);
    }
}
