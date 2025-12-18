package se.jensen.elias.javaspringbootdemo.service.impl;

import org.springframework.stereotype.Service;
import se.jensen.elias.javaspringbootdemo.dto.request.PostRequestDTO;
import se.jensen.elias.javaspringbootdemo.dto.response.PostResponseDTO;
import se.jensen.elias.javaspringbootdemo.mapper.impl.PostMapper;
import se.jensen.elias.javaspringbootdemo.model.Post;
import se.jensen.elias.javaspringbootdemo.model.User;
import se.jensen.elias.javaspringbootdemo.repository.PostRepository;
import se.jensen.elias.javaspringbootdemo.repository.UserRepository;
import se.jensen.elias.javaspringbootdemo.service.PostsService;

import java.util.List;

//Service ansvar för logiken
@Service
public class PostsServiceImpl implements PostsService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PostMapper postMapper;

    public PostsServiceImpl(PostRepository postRepository, UserRepository userRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.postMapper = postMapper;
    }

    //Hämtar alla Post objekt från repository, omvandlar dem till ResponseDTO och returnerar dem, med hjälp av stream.
    @Override
    public List<PostResponseDTO> getAllPosts() {
        return postRepository.findAll().stream()
                .map(postMapper::toResponseDTO)
                .toList();
    }

    //Tar emot RequestDTO, skapar ny Post-objekt, skickar Post-objektet till repository, gör om Post-objektet till ResponseDTO och returnerar det.
    @Override
    public PostResponseDTO createPost(Long userId, PostRequestDTO request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Post post = new Post(request.text(), user);
        Post savedPost = postRepository.save(post);

        user.getPosts().add(savedPost);

        return postMapper.toResponseDTO(savedPost);
    }

    //Tar id, frågar repository att hämta posten med samma id, returnerar den som ResponseDTO.
    @Override
    public PostResponseDTO getPostById(Long id) {
        return postMapper.toResponseDTO(postRepository.getById(id));
    }

    //Hämta posten med id, uppdatera innehållet med text från request,
    //konvertera till PostResponseDTO och returnera.
    @Override
    public PostResponseDTO updatePostById(Long id, PostRequestDTO newPost) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        post.setContent(newPost.text());
        Post updatedPost = postRepository.save(post);
        return postMapper.toResponseDTO(post);
    }

    //Raderar posten med id...
    @Override
    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }

    //Raderar alla posts
    @Override
    public void deleteAllPosts() {
        postRepository.deleteAll();
    }

}
