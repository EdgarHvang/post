package edu.miu.post.serviceImp;

import edu.miu.post.dto.ReactionModel;
import edu.miu.post.dto.response.ReactionResponse;
import edu.miu.post.entity.Post;
import edu.miu.post.entity.Reaction;
import edu.miu.post.repository.PostRepository;
import edu.miu.post.repository.ReactionRepository;
import edu.miu.post.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ReactionServiceImpl implements ReactionService {
    @Autowired
    private ReactionRepository repository;

    @Autowired
    private PostRepository postRepository;

    @Transactional
    public ReactionResponse react(Long id, boolean isLiked, HttpServletRequest req) throws Exception {

        Long userId = Long.parseLong(req.getHeader("user_id"));
        Optional<Reaction> optionalReaction = repository.findByUserId(userId);

        System.out.println(optionalReaction);
        Reaction reaction;

        if (optionalReaction.isPresent()) {
            reaction = optionalReaction.get();
            reaction.setLiked(isLiked);
        } else {
            Post post = postRepository.findById(id).orElseThrow(() -> new Exception(""));
            reaction = new Reaction(post, userId, isLiked);
        }
        repository.save(reaction);
        ReactionResponse response = new ReactionResponse(reaction.getUserId(),reaction.isLiked());
        return response;
    }

}
