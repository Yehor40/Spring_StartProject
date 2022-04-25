    package com.start.start.controllers;
    import com.start.start.models.Post;
    import com.start.start.repos.PostRepo;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestParam;

    import java.util.List;


    @Controller

    public class BlogController {
        @Autowired
    private PostRepo postRepo;

        @GetMapping("/blog")
        public String Blogmain(Model model) {
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
        @GetMapping("/main/add")
        public String Addtext(Model model) {
            return "main-add";

        }
        @PostMapping("/main/add")
        public String addtext(@RequestParam String title,@RequestParam String anons,@RequestParam String text, Model model) {
            Post post = new Post(title,anons,text);
            postRepo.save(post);
            return "redirect:/main";

        }

    }
