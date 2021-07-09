package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PostControl {
    private final PostService posts;

    public PostControl(PostService posts) {
        this.posts = posts;
    }

    @GetMapping("/addpost")
    public String create(Model model) {
        Post post = new Post();
        model.addAttribute("post", post);
        return "edit";
    }

    @GetMapping("/editpost")
    public String edit(HttpServletRequest request, Model model) {

        int id = Integer.parseInt(request.getParameter("id"));
        Post post = posts.getID(id);
        model.addAttribute("post", post);
        return "edit";
    }

    @GetMapping("/addcomment")
    public String addcomment(HttpServletRequest request, Model model) {

        int id = Integer.parseInt(request.getParameter("id"));
        Post post = posts.getID(id);
        model.addAttribute("post", post);
        return "post";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post, HttpServletRequest req) {
        posts.add(post);
        return "redirect:/";
    }
}
