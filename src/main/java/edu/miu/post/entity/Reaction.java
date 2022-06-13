package edu.miu.post.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @Author: Qiyao
 * @Date:6/10/22 15:03
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reaction {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//    @JsonIdentityReference(alwaysAsId = true)
    private Post post;

    private Long userId;

    private boolean liked;

    public Reaction(Post post, Long userId, boolean isLiked) {
        this.post = post;
        this.userId = userId;
        this.liked = isLiked;
    }

}
