package ru.akhramova.mapper;

import ru.akhramova.dto.PostDto;
import ru.akhramova.model.Post;

public class PostMapper {
    public Post dtoToModel(PostDto dto) {
        return new Post(dto.getId(), dto.getContent(), false);
    }

    public PostDto modelToDto(Post model) {
        return new PostDto(model.getId(), model.getContent());
    }
}
