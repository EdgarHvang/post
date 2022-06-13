package edu.miu.post.repository;

import edu.miu.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author: Qiyao
 * @Date:6/10/22 16:04
 */
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByUserId(Long id);

    @Query("select p from Post p where p.userId = ?1 " + "order by length(p.content) desc ")
    List<Post> findTheLongest(Long id);




}