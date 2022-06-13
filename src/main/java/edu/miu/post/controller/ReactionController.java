package edu.miu.post.controller;

import edu.miu.post.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ReactionController {

    @Autowired
    ReactionService service;

    @RequestMapping(value = "react/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> react(@PathVariable Long id, @RequestParam boolean reaction, HttpServletRequest req) throws Exception {
        return ResponseEntity.ok(service.react(id, reaction, req));
    }
}
