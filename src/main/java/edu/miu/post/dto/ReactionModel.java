package edu.miu.post.dto;

import edu.miu.post.entity.Reaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: Qiyao
 * @Date:6/10/22 22:46
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReactionModel {

    private Long id, userId;

    private boolean liked;

    public void fill(Reaction reaction) {
        setId(reaction.getId());
        setUserId(reaction.getUserId());
        setLiked(reaction.isLiked());
    }

}
