package com.ym.exam.board.container;

import com.ym.exam.board.controller.UsrArticleController;
import com.ym.exam.board.controller.UsrMemberController;

import java.util.Scanner;

public class Container {
  public static Scanner sc;
  public static UsrArticleController usrArticleController;
  public static UsrMemberController usrMemberController;

  static {
    sc = new Scanner(System.in);
    usrArticleController = new UsrArticleController();
    usrMemberController = new UsrMemberController();
  }
}
