package ru.job4j.forum.control;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class PostControlTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @Test
    @WithMockUser
    public void create() throws Exception {
        this.mockMvc.perform(get("/addpost"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("edit"));
    }

    @Test
    @WithMockUser
    public void edit() throws Exception {
        Mockito.doReturn(Mockito.mock(Post.class)).when(postService).getID(1);
        this.mockMvc.perform(get("/editpost").param("id", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("edit"));
    }

    @Test
    @WithMockUser
    public void addcomment() throws Exception {
        Mockito.doReturn(Mockito.mock(Post.class)).when(postService).getID(1);
        this.mockMvc.perform(get("/addcomment").param("id", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post"));
    }
}