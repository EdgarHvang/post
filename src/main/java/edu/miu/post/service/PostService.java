package edu.miu.post.service;

import edu.miu.post.dto.request.LikedRequest;
import edu.miu.post.dto.response.DeletePostResponse;
import edu.miu.post.dto.response.LongestPostResponse;
import edu.miu.post.dto.response.LikedPostResonse;
import edu.miu.post.dto.response.PostsResponse;
import edu.miu.post.dto.request.NewPostRequest;
import edu.miu.post.dto.request.UpdatePostRequest;
import edu.miu.post.entity.Post;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: Qiyao
 * @Date:6/10/22 16:04
 */
public interface PostService {

    Post add(NewPostRequest newPostRequest, HttpServletRequest req);

    Post update(UpdatePostRequest updatePostRequest, HttpServletRequest req);

    DeletePostResponse delete(Long postId, HttpServletRequest req);

    List<PostsResponse>  getAll(HttpServletRequest req);

    LongestPostResponse longest(HttpServletRequest req);

    LikedPostResonse likes(LikedRequest likedRequest, HttpServletRequest req);

}
