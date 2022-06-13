package edu.miu.post.serviceImp;

import edu.miu.post.dto.request.LikedRequest;
import edu.miu.post.dto.response.DeletePostResponse;
import edu.miu.post.dto.response.LongestPostResponse;
import edu.miu.post.dto.response.LikedPostResonse;
import edu.miu.post.dto.response.PostsResponse;
import edu.miu.post.dto.request.NewPostRequest;
import edu.miu.post.dto.request.UpdatePostRequest;
import edu.miu.post.entity.Post;
import edu.miu.post.repository.PostRepository;
import edu.miu.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Author: Qiyao
 * @Date:6/10/22 16:04
 */

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    public Post add(NewPostRequest newPostRequest, HttpServletRequest req) {
        Post post = new Post(newPostRequest.getTitle(), newPostRequest.getPicture(), newPostRequest.getContent());
        post.setUserId(Long.parseLong(req.getHeader("user_id")));
        postRepository.save(post);
        return post;
    }

    public Post update(UpdatePostRequest updatePostRequest, HttpServletRequest req) {
        Post post = new Post(updatePostRequest.getId(), updatePostRequest.getTitle(), updatePostRequest.getPicture(), updatePostRequest.getContent());
        if (postRepository.findById(post.getId()).get().getUserId() == Long.parseLong(req.getHeader("user_id"))) {
            post.setUserId(Long.parseLong(req.getHeader("user_id")));
            postRepository.save(post);
            return post;
        } else {
            return null;
        }
    }

    @Override
    public DeletePostResponse delete(Long postId, HttpServletRequest req) {
        long userId = Long.parseLong(req.getHeader("user_id"));
        Post post = postRepository.findById(postId).get();
        DeletePostResponse response = new DeletePostResponse();
        response.fill(post);
        if (userId == post.getUserId()) {
            postRepository.delete(post);
            return response;
        } else {
            return null;
        }
    }

    public List<PostsResponse> getAll(HttpServletRequest req) {
        Long userId = Long.parseLong(req.getHeader("user_id"));
        List<PostsResponse> responses = new ArrayList<>();
        postRepository.findAllByUserId(userId).forEach(post -> {
            PostsResponse response = new PostsResponse();
            responses.add(response);
            response.fill(post);
        });
        return responses;
    }

    @Override
    public LongestPostResponse longest(HttpServletRequest req) {
        Long userId = Long.parseLong(req.getHeader("user_id"));
        List<Post> posts = postRepository.findTheLongest(userId);

        if (posts.size() > 0) {

            LongestPostResponse response = new LongestPostResponse(posts.get(0).getTitle(),posts.get(0).getPicture(),posts.get(0).getContent());
            return response;
        } else {
            return null;
        }
    }

    @Override
    public LikedPostResonse likes(LikedRequest likedRequest, HttpServletRequest req){
        Long userId = Long.parseLong(req.getHeader("user_id"));
        Post post = postRepository.findById(likedRequest.getPostId()).get();
        if (post.getUserId() == userId){
            LikedPostResonse response = new LikedPostResonse();
            response.fill(post);
            return response;
        }else {
            return null;
        }

    }


}
