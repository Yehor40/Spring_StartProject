package com.start.start.controllers;

import com.start.start.models.Post;
import com.start.start.repos.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class BlogController {

private PostRepo postRepo;
    @GetMapping("/blog")
    public String MainContrl(Model model) {
        //kindda hello world
        model.addAttribute("title","Start project text");
        Iterable<Post> posts = postRepo.findAll();
        model.addAttribute("posts",posts);
        return "blog";

    }


}
