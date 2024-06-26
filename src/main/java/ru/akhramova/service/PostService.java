package ru.akhramova.service;

import org.springframework.stereotype.Service;
import ru.akhramova.exception.NotFoundException;
import ru.akhramova.model.Post;
import ru.akhramova.repository.PostRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
  private final PostRepository repository;

  public PostService(PostRepository repository) {
    this.repository = repository;
  }

  public List<Post> all() {
    return repository.all();
  }

  public Optional<Post> getById(long id) {
    return repository.getById(id);
  }

  public Post save(Post post) {
    return repository.save(post);
  }

  public void removeById(long id) {
    repository.removeById(id);
  }
}

