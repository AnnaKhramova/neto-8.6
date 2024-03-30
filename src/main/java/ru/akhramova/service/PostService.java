package ru.akhramova.service;

import org.springframework.stereotype.Service;
import ru.akhramova.dto.PostDto;
import ru.akhramova.exception.NotFoundException;
import ru.akhramova.repository.PostRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
  private final PostRepository repository;

  public PostService(PostRepository repository) {
    this.repository = repository;
  }

  public List<PostDto> all() {
    return repository.all();
  }

  public Optional<PostDto> getById(long id) {
    return repository.getById(id);
  }

  public PostDto save(PostDto post) {
    return repository.save(post);
  }

  public void removeById(long id) {
    repository.removeById(id);
  }
}

