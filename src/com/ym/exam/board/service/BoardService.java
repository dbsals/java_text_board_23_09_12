package com.ym.exam.board.service;

import com.ym.exam.board.container.Container;
import com.ym.exam.board.repository.ArticleRepository;
import com.ym.exam.board.repository.BoardRepository;
import com.ym.exam.board.vo.Article;
import com.ym.exam.board.vo.Board;

import java.util.List;

public class BoardService {
  private BoardRepository boardRepository;
  public BoardService() {
    boardRepository = Container.getBoardRepository();
  }

  public Board getBoardById(int boardId) {
    return boardRepository.getBoardById(boardId);
  }
}