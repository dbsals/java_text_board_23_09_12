package com.ym.exam.board.container;

import com.ym.exam.board.controller.UsrArticleController;

import java.util.Scanner;

public class Container {
  public static Scanner sc;
  public static UsrArticleController usrArticleController;

  static {
    sc = new Scanner(System.in);
    usrArticleController = new UsrArticleController();
  }
}
