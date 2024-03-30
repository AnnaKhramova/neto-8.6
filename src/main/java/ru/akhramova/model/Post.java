package ru.akhramova.model;

public class Post {
  private long id;
  private String content;
  private Boolean removed;

  public Post() {
  }

  public Post(long id, String content, Boolean removed) {
    this.id = id;
    this.content = content;
    this.removed = removed;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Boolean getRemoved() {
    return removed;
  }

  public void setRemoved(Boolean removed) {
    this.removed = removed;
  }
}
