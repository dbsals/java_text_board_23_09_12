package com.ym.exam.board;

public class Article {
  public int id;
  public String title;
  public String content;

  public Article(int id, String title, String content) {
    this.id = id;
    this.title = title;
    this.content = content;
  }

  @Override
  public String toString() {
    return String.format("{id : %d, title : \"%s\", content : \"%s\"}", id, title, content);
  }
}