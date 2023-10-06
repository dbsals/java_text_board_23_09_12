package com.ym.exam.board.controller;

import com.ym.exam.board.Article;
import com.ym.exam.board.Member;
import com.ym.exam.board.Rq;
import com.ym.exam.board.container.Container;

import java.util.ArrayList;
import java.util.List;

public class UsrMemberController {
  private int memberLastId;
  private List<Member> members;

  public UsrMemberController() {
    memberLastId = 0;
    members = new ArrayList<>();

    makeTestDate();

    if(members.size() > 0) {
      memberLastId = members.get(members.size() - 1).id;
    }
  }

  void makeTestDate() {
    // 테스트 게시물을 100개로 늘림.
    for(int i = 1; i <= 3; i++ ) {
      members.add(new Member(i, "user" + i, "user" + i, "홍길동" + i));
    }
  }

  public void actionJoin(Rq rq) {
    System.out.println("== 회원 가입 ==");
    System.out.printf("로그인 아이디 : ");
    String loginId = Container.sc.nextLine();

    System.out.printf("로그인 패스워드 : ");
    String loginPw = Container.sc.nextLine();

    System.out.printf("로그인 패스워드 확인 : ");
    String loginPwConfirm = Container.sc.nextLine();

    if(loginPw.equals(loginPwConfirm) == false) {
      System.out.println("비밀번호가 일치하지 않습니다.");
      return;
    }

    System.out.printf("이름 : ");
    String name = Container.sc.nextLine();

    int id = ++memberLastId;

    Member member = new Member(id, loginId, loginPw, name);

    members.add(member);

    System.out.printf("\"%s\"님 회원가입을 환영합니다.\n", member.name);

  }

  public void actionLogin(Rq rq) {
    boolean isLogined = rq.hasSessionAttr("loginedMember");
    if(isLogined) {
      System.out.println("이미 로그인 되어 있습니다.");
      System.out.println("로그아웃 후 이용해주세요.");
      return;
    }

    System.out.println("== 로그인 ==");
    System.out.printf("로그인 아이디 : ");
    String loginId = Container.sc.nextLine();

    if(loginId.trim().length() == 0) {
      System.out.println("로그인 아이디를 입력해주세요.");
      return;
    }

    Member member = getMemberLoginId(loginId);

    if(member == null) {
      System.out.println("해당 아이디는 존재하지 않습니다.");
      return;
    }

    System.out.printf("로그인 패스워드 : ");
    String loginPw = Container.sc.nextLine();

    if(loginPw.trim().length() == 0) {
      System.out.println("로그인 패스워드를 입력해주세요.");
      return;
    }

    if(member.loginPw.equals(loginPw) == false) {
      System.out.println("로그인 패스워드가 일치하지 않습니다.");
      System.out.println("다시 확인 후 입력해주세요.");
      return;
    }

    rq.setSessionAttr("loginedMember", member);

    System.out.printf("\"%s\"님 환영합니다.\n", member.name);
  }

  private Member getMemberLoginId(String loginId) {
    for(Member member : members) {
      if(member.loginId.equals(loginId)) {
        return member;
      }
    }

    return null;
  }

  public void actionLogout(Rq rq) {
    boolean isLogout = rq.hasSessionAttr("loginedMember");

    if(!isLogout) {
      System.out.println("이미 로그아웃 상태입니다.");
      return;
    }

    rq.removeSessionAttr("loginedMember");
    System.out.println("로그아웃 되었습니다.");
  }

}