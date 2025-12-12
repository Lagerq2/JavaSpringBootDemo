package se.jensen.elias.javaspringbootdemo.service.impl;

import org.springframework.stereotype.Service;
import se.jensen.elias.javaspringbootdemo.dto.request.PostRequestDTO;
import se.jensen.elias.javaspringbootdemo.dto.response.PostResponseDTO;
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

    public PostsServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    //Hämtar alla Post objekt från repository, omvandlar dem till ResponseDTO och returnerar dem, med hjälp av stream.
    @Override
    public List<PostResponseDTO> getAllPosts() {
        return postRepository.getAllPosts().stream()
                .map(this::toResponseDTO)
                .toList();
    }

    //Tar emot RequestDTO, skapar ny Post-objekt, skickar Post-objektet till repository, gör om Post-objektet till ResponseDTO och returnerar det.
    @Override
    public PostResponseDTO createPost(PostRequestDTO request) {
        User user = userRepository.getUserById(request.userId());
        Post post = new Post(request.text(), user);
        postRepository.saveCreatedPost(post);
        user.addPosts(post);
        return toResponseDTO(post);
    }

    //Tar id, frågar repository att hämta posten med samma id, returnerar den som ResponseDTO.
    @Override
    public PostResponseDTO getPostById(Long id) {
        return toResponseDTO(postRepository.getPostById(id));
    }

    //Hämta posten med id, uppdatera innehållet med text från request,
    //konvertera till PostResponseDTO och returnera.
    @Override
    public PostResponseDTO updatePostById(Long id, PostRequestDTO newPost) {
        Post post = postRepository.getPostById(id);
        if (post == null) {
            throw new IllegalArgumentException("Post not found");
        }
        postRepository.updatePost(post, newPost.text());
        return toResponseDTO(post);


    }

    @Override
    public void deletePostById(Long id) {
        postRepository.deletePostById(id);
    }

    @Override
    public void deleteAllPosts() {
        postRepository.deleteAllPosts();
    }

    private PostResponseDTO toResponseDTO(Post post) {
        return new PostResponseDTO(
                post.getId(),
                post.getContent(),
                post.getCreatedAt()
        );
    }
}
