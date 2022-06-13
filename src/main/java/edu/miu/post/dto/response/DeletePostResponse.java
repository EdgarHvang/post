package edu.miu.post.dto.response;

import edu.miu.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeletePostResponse {
    private Long id, userId;

    private String title, picture, content;

    private LocalDate postedDate, updateDate;

    private List<ReactionResponse> reactions = new ArrayList<>();

    public void fill(Post post) {
        setId(post.getId());
        setUserId(post.getUserId());
        setTitle(post.getTitle());
        setPicture(post.getPicture());
        setContent(post.getContent());
        setPostedDate(post.getPostedDate());
        setUpdateDate(post.getUpdateDate());
        post.getReactions().forEach(reaction -> {
            ReactionResponse reactionModel = new ReactionResponse();
            reactionModel.fill(reaction);
            reactions.add(reactionModel);
        });
    }
}
