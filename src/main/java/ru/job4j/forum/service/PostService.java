package ru.job4j.forum.service;


import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.store.PostRepository;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class PostService {
    private final PostRepository posts;

    public PostService(PostRepository posts) {
        this.posts = posts;
    }

    public void add(Post post) {
        if (post.getCreated() == null) {
            post.setCreated(new GregorianCalendar());
        }
        posts.save(post);
    }

    public List<Post> getAll() {
        List<Post> rsl = new ArrayList<>();
        posts.findAll().forEach(rsl::add);
        return rsl;
    }

    public Post getID(long id) {
        Post post = posts.findById(id).get();
        return post;
    }
}