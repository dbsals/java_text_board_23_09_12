package com.ym.exam.board.container;

import com.ym.exam.board.controller.UsrArticleController;
import com.ym.exam.board.controller.UsrMemberController;
import com.ym.exam.board.repository.ArticleRepository;
import com.ym.exam.board.repository.MemberRepository;
import com.ym.exam.board.service.ArticleService;
import com.ym.exam.board.service.MemberService;
import com.ym.exam.board.session.Session;

import java.util.Scanner;

public class Container {
  public static Scanner sc;
  public static Session session;

  public static ArticleRepository articleRepository;
  public static ArticleService articleService;

  public static MemberRepository memberRepository;
  public static MemberService memberService;

  public static UsrArticleController usrArticleController;
  public static UsrMemberController usrMemberController;

  static {
    sc = new Scanner(System.in);
    session = new Session();

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