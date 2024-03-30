package ru.akhramova.repository.impl;

import org.springframework.stereotype.Repository;
import ru.akhramova.dto.PostDto;
import ru.akhramova.mapper.PostMapper;
import ru.akhramova.model.Post;
import ru.akhramova.repository.PostRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PostRepositoryImpl implements PostRepository {
  private final PostMapper postMapper = new PostMapper();

  static AtomicLong maxId = new AtomicLong(0);

  private Map<Long, Post> posts = new ConcurrentHashMap<>();

  public List<PostDto> all() {
    return posts.values().stream().map(postMapper::modelToDto).toList();
  }

  public Optional<PostDto> getById(long id) {
    if (posts.containsKey(id)) {
      Post model = posts.get(id);
      if (!model.getRemoved()) {
        return Optional.ofNullable(postMapper.modelToDto(model));
      }
    }
    return Optional.empty();
  }

  public PostDto save(PostDto post) {
    if (post.getId() == 0L) {
      post.setId(maxId.incrementAndGet());
    } else if (post.getId() > maxId.longValue()) {
      return null;
    }
    posts.put(post.getId(), postMapper.dtoToModel(post));
    return post;
  }

  public void removeById(long id) {
    posts.get(id).setRemoved(true);
  }
}
