package com.scorp.socialmedia.service;

import com.scorp.socialmedia.entity.Post;
import com.scorp.socialmedia.repository.LikeRepository;
import com.scorp.socialmedia.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
