/*
-[O] 환영메세지 출력
-[O] 고객으로부터 명령어 입력받기
   -[O] 스캐너 객체라도 하나 만들어보기
   -[O] 받은 명령어 출력하기
-[O] exit 명령어 처리
   -[O] exit 입력받으면 종료라고 출력하기
   -[O] exit 입력받을 때 까지 계속 실행
-[O] /usr/article/write 명령어 입력처리
   -[O] 시작문구라고 출력
   -[O]  제목과 내용이라도 입력받기
   -[O]  생성된 게시물 번호 출력
   -[O]  생성될 때마다 게시물 번호가 증가
   -[O]  생성된 게시물을 객체에 담기
   -[O]  Article 객체 생성하기
   -[O]  Article 클래스 생성하기
-[O] toString 메서드 오버라이드 해서 생성된 게시물 객체 쉽게 보기
-[O] 생성자 도입
*/

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
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