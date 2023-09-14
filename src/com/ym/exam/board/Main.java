package com.ym.exam.board;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int number = 0;

    System.out.println("== 자바 텍스트 게시판 ==");
    System.out.println("== 프로그램 시작 ==");

    while (true) {
      System.out.printf("명령) ");
      String cmd = sc.nextLine();

      if (cmd.equals("/usr/article/write")) {
        System.out.println("== 게시물 등록 ==");
        System.out.printf("제목 : ");
        String title = sc.nextLine();

        System.out.printf("내용 : ");
        String content = sc.nextLine();

        number++;
        System.out.printf("%d번 게시물이 등록되었습니다.\n", number);
      }

      else if (cmd.equals("exit")) {
        System.out.println("프로그램을 종료합니다.");
        break;
      }

      else {
        System.out.println("잘못된 명령어를 입력했습니다.");
      }
    }

    sc.close();
  }
}