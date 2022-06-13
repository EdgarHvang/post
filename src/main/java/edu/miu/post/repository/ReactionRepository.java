package edu.miu.post.repository;

import edu.miu.post.entity.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * @Author: Qiyao
 * @Date:6/10/22 22:20
 */

public interface ReactionRepository extends JpaRepository<Reaction, Long> {

    Optional<Reaction> findByUserId(Long userId);
//    Optional<Reaction> findBy

}
