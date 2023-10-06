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
    for(int i = 1; i <= 5; i++ ) {
      members.add(new Member(i, "user" + i, "user" + i, "홍길동" + i));
    }
  }

  public void actionJoin(Rq rq) {
    System.out.println("== 회원 가입 ==");
    System.out.printf("로그인 아이디 : ");
    String loginId = Container.sc.nextLine();

    System.out.printf("로그인 패스워드 : ");
    String loginPw = Container.sc.nextLine();

    System.out.printf("로그인 패스워드 : ");
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
}
