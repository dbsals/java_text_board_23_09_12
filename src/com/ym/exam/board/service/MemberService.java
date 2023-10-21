package com.ym.exam.board.service;

import com.ym.exam.board.container.Container;
import com.ym.exam.board.repository.MemberRepository;
import com.ym.exam.board.vo.Member;

public class MemberService {
  private MemberRepository memberRepository;

  public MemberService() {
    memberRepository = Container.getMemberRepository();

    makeTestDate();
  }

  public void makeTestDate() {
    for(int i = 1; i <= 3; i++ ) {
      String loginId = "user" + i;
      String loginPw = "user" + i;
      String name = "회원" + i;
      join(loginId, loginPw, name);
    }
  }

  public void join(String loginId, String loginPw, String name) {
    memberRepository.join(loginId, loginPw, name);
  }

  public Member getMemberLoginId(String loginId) {
    return memberRepository.getMemberLoginId(loginId);
  }

  public Member getMemberById(int id) {
    return memberRepository.getMemberById(id);
  }
}