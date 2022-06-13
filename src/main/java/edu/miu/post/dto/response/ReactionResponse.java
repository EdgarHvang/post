package edu.miu.post.dto.response;

import edu.miu.post.entity.Reaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReactionResponse {

    private Long userId;

    private boolean liked;

    public void fill(Reaction reaction) {
        setUserId(reaction.getUserId());
        setLiked(reaction.isLiked());
    }

}
