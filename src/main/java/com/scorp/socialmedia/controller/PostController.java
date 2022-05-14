package com.scorp.socialmedia.controller;

import com.scorp.socialmedia.entity.Post;
import com.scorp.socialmedia.model.GetPostResponse;
import com.scorp.socialmedia.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "post")
public class PostController {
    private final PostService postService;

    @GetMapping(value = "/posts")
    public ResponseEntity<GetPostResponse> getAllPosts(@RequestParam Integer userId,@RequestParam List<Integer> idList, Integer requestedUserId) {
        return ResponseEntity.ok(postService.getPosts(userId,idList,requestedUserId));
    }

    @GetMapping(value = "/merge-posts")
    public ResponseEntity<List<Post>> mergePosts() {
        return ResponseEntity.ok(postService.mergePosts());
    }
}
