package com.scorp.socialmedia.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;

    @Column(nullable = false)
    protected Date created;

    @Column
    private String userName;

    @Column
    private String email;

    @Column
    private String fullName;

    @Column
    private String profilePicture;

    @Column
    private String bio;

    @Transient
    private boolean followed;

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }
}
