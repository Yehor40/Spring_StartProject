    package com.start.start.controllers;
    import com.start.start.models.Post;
    import com.start.start.repos.PostRepo;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;

    import java.util.List;


    @Controller

    public class BlogController {
        @Autowired
    private PostRepo postRepo;

        @GetMapping("/blog")
        public String main(Model model) {
            //kindda hello world
            model.addAttribute("title","Start project text");
            return "blog";

        }

        @GetMapping("/main")
        public String Postmain(Model model) {
            List<Post> posts = (List<Post>) postRepo.findAll();
            model.addAttribute("posts",posts);

            return "main";

        }
    }
