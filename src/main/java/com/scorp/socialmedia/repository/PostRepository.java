package com.scorp.socialmedia.repository;

import com.scorp.socialmedia.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query(value = "select * from posts where id = ?1 ",
            nativeQuery = true)
    Post findPostById(Integer id);
}
