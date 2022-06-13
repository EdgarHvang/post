package edu.miu.post.controller;

import edu.miu.post.dto.request.LikedRequest;
import edu.miu.post.dto.request.NewPostRequest;
import edu.miu.post.dto.request.UpdatePostRequest;
import edu.miu.post.exception.BusinessException;
import edu.miu.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @Author: Qiyao
 * @Date:6/10/22 15:24
 */
@RestController
public class PostController {

    @Autowired
    PostService service;

//    @Autowired
//    private ReactionService reactionService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> add(@Valid @RequestBody NewPostRequest newPostRequest, HttpServletRequest req) throws BusinessException {
        return ResponseEntity.ok(service.add(newPostRequest, req)) ;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll(HttpServletRequest req) throws BusinessException{
//        System.out.println("sssss");
        return ResponseEntity.ok(service.getAll(req));
    }

    @PostMapping(value = "/update")
    public ResponseEntity<?> update(@Valid @RequestBody UpdatePostRequest updatePostRequest, HttpServletRequest req) throws BusinessException{
        return ResponseEntity.ok(service.update(updatePostRequest, req));
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<?> delete(@Valid @RequestParam Long postId, HttpServletRequest req) throws BusinessException{
//        System.out.println(postId);
        return ResponseEntity.ok(service.delete(postId,req));
    }

    @GetMapping(value =  "/longest")
    public ResponseEntity<?> longest(HttpServletRequest req) throws BusinessException{
        return ResponseEntity.ok(service.longest(req));
    }

    @GetMapping(value = "/likes")
    public ResponseEntity<?> like(@Valid @RequestBody LikedRequest likedRequest, HttpServletRequest req) throws BusinessException{
        return ResponseEntity.ok(service.likes(likedRequest ,req));
    }
}
