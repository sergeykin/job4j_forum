package ru.job4j.forum.service;


import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PostService {
    private final AtomicInteger atomicInteger = new AtomicInteger();

    private final List<Post> posts = new ArrayList<>();

    public PostService() {
        Post post = Post.of("Продаю машину ладу 01.");
        post.setId(atomicInteger.incrementAndGet());
        posts.add(post);
    }

    public void add(Post post) {
        if (post.getId() == 0) {
            post.setId(atomicInteger.incrementAndGet());
        } else {
            for (Post tmp : posts) {
                if (post.getId() == tmp.getId()) {
                    tmp.setName(post.getName());
                    tmp.setCreated(post.getCreated());
                    tmp.setDesc(post.getDesc());
                    tmp.setComments(post.getComments());
                    return;
                }
            }
        }
        posts.add(post);
    }

    public List<Post> getAll() {
        return posts;
    }

    public Post getID(int id) {
        Post post = null;
        for (Post tmppost : posts) {
            if (tmppost.getId() == id) {
                post = tmppost;
                break;
            }
        }
        return post;
    }
}