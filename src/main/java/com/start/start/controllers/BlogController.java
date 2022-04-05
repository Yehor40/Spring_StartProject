package com.start.start.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BlogController {

    @GetMapping("/blog")
    public String main(Model model) {
        model.addAttribute("title","Start project blog");
        return "blog";
    }

}
