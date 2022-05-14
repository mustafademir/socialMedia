package com.scorp.socialmedia.repository;

import com.scorp.socialmedia.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Integer> {
}
