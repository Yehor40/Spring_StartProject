    package com.start.start.controllers;
    import com.start.start.models.Post;
    import com.start.start.repos.PostRepo;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestParam;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Optional;


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

        public String addtext1(@RequestParam String title,@RequestParam String anons,@RequestParam String text, Model model) {
            Post post = new Post(title,anons,text);
            postRepo.save(post);
            return "redirect:/main";

        }
        @GetMapping("/main/{id}")
        public String More(@PathVariable(value = "id") long id, Model model) {
           Optional<Post> post = postRepo.findById(id);
            ArrayList<Post> p = new ArrayList<>();
            post.ifPresent(p::add);
            model.addAttribute("post",p);
            return "more";

        }
        @GetMapping("/main/{id}/delete")
        public String Del(@PathVariable(value = "id") long id, Model model) {
        Post post = postRepo.findById(id).orElseThrow();
        postRepo.delete(post);
            return "redirect:/main";

        }
        @GetMapping("/main/{id}/update")
        public String UPDtext(@PathVariable(value = "id") long id,Model model) {
            if(!postRepo.existsById(id)){
                return "redirect:/main";
            }
            Optional<Post> pst = postRepo.findById(id);
            ArrayList<Post>res = new ArrayList<>();
            pst.ifPresent(res::add);
            model.addAttribute("post",res);
            return "update";

        }
        @PostMapping("/main/{id}/update")
        public String Upd(@PathVariable(value = "id") long id, Model model,@RequestParam String title,@RequestParam String anons,@RequestParam String text ) {
            Post post = postRepo.findById(id).orElseThrow();
            post.setTitle(title);
            post.setAnons(anons);
            post.setText(text);
            postRepo.save(post);
            model.addAttribute("post",model);
            return "redirect:/main" ;

        }

    }
