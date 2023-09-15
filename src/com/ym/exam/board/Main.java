package com.ym.exam.board;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Article lastarticle = null;
    int num = 0;

    System.out.println("== 환영합니다 ==");

    while(true){
      System.out.printf("명령어) ");
      String cmd = sc.nextLine();

      if(cmd.equals("/usr/article/write")){
        System.out.println("== 게시물 등록 ==");
        System.out.printf("title : ");
        String title = sc.nextLine();

        System.out.printf("content : ");
        String content = sc.nextLine();

        num++;

        Article articles = new Article(num, title, content);
        System.out.println("게시물이 추가 되었습니다.");
        System.out.println(articles);

        lastarticle = articles;
      }

      else if(cmd.equals("/usr/article/detail")){
        if(num == 0){
          System.out.println("게시물이 존재하지 않습니다.");
          continue;
        }

        System.out.println("== 게시물 상세보기 ==");
        System.out.printf("번호 : %d\n", lastarticle.id);
        System.out.printf("제목 : %s\n", lastarticle.title);
        System.out.printf("내용 : %s\n", lastarticle.content);
      }

      else if(cmd.equals("exit")){
        System.out.println("프로그램을 종료합니다.");
        break;
      }

      else{
        System.out.println("올바른 명령어를 입력해주세요.");
      }
    }

    sc.close();;
  }
}

class Article{
  int id;
  String title;
  String content;

  Article(int id, String title, String content){
    this.id = id;
    this.title = title;
    this.content = content;
  }

  @Override
  public String toString(){
    return String.format("{id : %d, title : \"%s\", content : \"%s\"}", id, title, content);
  }
}