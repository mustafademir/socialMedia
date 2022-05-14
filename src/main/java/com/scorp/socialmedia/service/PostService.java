package com.scorp.socialmedia.service;

import com.scorp.socialmedia.entity.Post;
import com.scorp.socialmedia.entity.User;
import com.scorp.socialmedia.model.GetPostResponse;
import com.scorp.socialmedia.repository.FollowRepository;
import com.scorp.socialmedia.repository.LikeRepository;
import com.scorp.socialmedia.repository.PostRepository;
import com.scorp.socialmedia.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final FollowRepository followRepository;

    public GetPostResponse getPosts(Integer userId,List<Integer> postIds, Integer requestedUserId) {
        User user = userRepository.findUSerById(userId);
        user.setFollowed(followRepository.existsById(requestedUserId));
        List<Post> postList = new ArrayList<>();
        postIds.forEach(id -> {
            Post post = postRepository.findPostById(id);
            post.setLiked(likeRepository.existsById(post.getId()));
            postList.add(post);
        });
        GetPostResponse getPostResponse = new GetPostResponse();
        getPostResponse.setPosts(postList);
        getPostResponse.setUser(user);
        return getPostResponse;
    }

    public List<Post> mergePosts() {
        List<List<Post>> list_of_posts = new ArrayList<>();
        Post post1 = postRepository.findPostById(1);
        Post post2 = postRepository.findPostById(2);
        Post post3 = postRepository.findPostById(3);
        Post post4 = postRepository.findPostById(4);
        Post post5 = postRepository.findPostById(5);
        Post post6 = postRepository.findPostById(6);
        List<Post> postList1 = new ArrayList<>();
        postList1.add(post1);
        postList1.add(post2);
        postList1.add(post3);
        List<Post> postList2 = new ArrayList<>();
        postList2.add(post3);
        postList2.add(post4);
        postList2.add(post5);
        List<Post> postList3 = new ArrayList<>();
        postList3.add(post6);
        list_of_posts.add(postList1);
        list_of_posts.add(postList2);
        list_of_posts.add(postList3);
        List<Post> postList = new ArrayList<>();
        list_of_posts.forEach( list -> {
            list.forEach( post -> {
                postList.add(post);
            });
        });
        return postList.stream()
                .distinct()
                .sorted(Comparator.comparing(Post::getCreated).reversed().thenComparing(Post::getId).reversed())
                .collect(Collectors.toList());
    }
}
