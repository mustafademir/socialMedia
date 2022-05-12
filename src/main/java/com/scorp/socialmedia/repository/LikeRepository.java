package com.scorp.socialmedia.repository;

import com.scorp.socialmedia.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
