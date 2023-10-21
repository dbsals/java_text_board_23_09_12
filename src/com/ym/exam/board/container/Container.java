package com.ym.exam.board.container;

import com.ym.exam.board.controller.UsrArticleController;
import com.ym.exam.board.controller.UsrMemberController;
import com.ym.exam.board.interceptor.NeedLoginInterceptor;
import com.ym.exam.board.interceptor.NeedLogoutInterceptor;
import com.ym.exam.board.repository.ArticleRepository;
import com.ym.exam.board.repository.BoardRepository;
import com.ym.exam.board.repository.MemberRepository;
import com.ym.exam.board.service.ArticleService;
import com.ym.exam.board.service.BoardService;
import com.ym.exam.board.service.MemberService;
import com.ym.exam.board.session.Session;

import java.util.Scanner;

public class Container {
  private static Scanner sc;
  private static Session session;

  private static NeedLoginInterceptor needLoginInterceptor;
  private static NeedLogoutInterceptor needLogoutInterceptor;

  private static BoardRepository boardRepository;
  private static BoardService boardService;

  private static ArticleRepository articleRepository;
  private static ArticleService articleService;

  private static MemberRepository memberRepository;
  private static MemberService memberService;

  private static UsrArticleController usrArticleController;
  private static UsrMemberController usrMemberController;

  static {
    sc = new Scanner(System.in);
    session = new Session();

    needLoginInterceptor = new NeedLoginInterceptor();
    needLogoutInterceptor = new NeedLogoutInterceptor();

    boardRepository = new BoardRepository();
    boardService = new BoardService();

    articleRepository = new ArticleRepository();
    articleService = new ArticleService();

    memberRepository = new MemberRepository();
    memberService = new MemberService();

    usrArticleController = new UsrArticleController();
    usrMemberController = new UsrMemberController();
  }

  public static Scanner getSc() {
    return sc;
  }

  public static NeedLoginInterceptor getNeedLoginInterceptor() {
    return needLoginInterceptor;
  }

  public static NeedLogoutInterceptor getNeedLogoutInterceptor() {
    return needLogoutInterceptor;
  }

  public static BoardRepository getBoardRepository() {
    return boardRepository;
  }

  public static BoardService getBoardService() {
    return boardService;
  }

  public static ArticleRepository getArticleRepository() {
    return articleRepository;
  }

  public static ArticleService getArticleService() {
    return articleService;
  }

  public static MemberRepository getMemberRepository() {
    return memberRepository;
  }

  public static MemberService getMemberService() {
    return memberService;
  }

  public static UsrArticleController getUsrArticleController() {
    return usrArticleController;
  }

  public static UsrMemberController getUsrMemberController() {
    return usrMemberController;
  }

  public static Session getSession() {
    return session;
  }
}