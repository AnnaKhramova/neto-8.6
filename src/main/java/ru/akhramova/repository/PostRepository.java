package ru.akhramova.repository;

import ru.akhramova.dto.PostDto;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    List<PostDto> all();

    Optional<PostDto> getById(long id);

    PostDto save(PostDto post);

    void removeById(long id);
}
