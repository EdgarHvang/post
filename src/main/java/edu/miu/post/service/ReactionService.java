package edu.miu.post.service;

import edu.miu.post.dto.ReactionModel;
import edu.miu.post.dto.response.ReactionResponse;
import edu.miu.post.entity.Reaction;

import javax.servlet.http.HttpServletRequest;

public interface ReactionService {

    ReactionResponse react(Long id, boolean reaction, HttpServletRequest req) throws Exception;

}
