package edu.miu.post.dto.response;

import edu.miu.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LikedPostResonse {

    private List<Long> likesUsers = new ArrayList<>();

    public void fill(Post post) {
        post.getReactions().forEach(reaction -> {
            ReactionResponse reactionModel = new ReactionResponse();
            reactionModel.fill(reaction);
            likesUsers.add(reactionModel.getUserId());
        });
    }

}
