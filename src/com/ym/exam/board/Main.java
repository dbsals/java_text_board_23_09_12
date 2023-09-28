package com.ym.exam.board;

import java.util.*;

public class Main {
  static int articleLastId = 0;
  static List<Article> articles = new ArrayList<>();

  static void makeTestDate(List<Article> articles) {
    for(int i = 1; i <= 100; i++) {
      articles.add(new Article(i, "제목" + i, "내용" + i));
    }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    makeTestDate(articles);

    if(articles.size() > 0) {
      articleLastId = articles.get(articles.size() - 1).id;
    }

    System.out.println("== 자바 텍스트 게시판 ==");
    System.out.println("== 프로그램 시작 ==");

    while (true) {
      System.out.printf("명령) ");
      String cmd = sc.nextLine();

      Rq rq = new Rq(cmd);

      Map<String, String> params = rq.getParams();

      if(rq.getUrlPath().equals("/usr/article/write")) {
        actionUsrArticleWrite(sc);

      }
      else if(rq.getUrlPath().equals("/usr/article/list")) {
        actionUsrArticleList(rq);

      }
      else if(rq.getUrlPath().equals("/usr/article/detail")) {
        actionUsrArticleDetail(rq);

      }
      else if(rq.getUrlPath().equals("/usr/article/modify")) {
        actionUsrAtticleModify(sc, rq);

      }
      else if(rq.getUrlPath().equals("/usr/article/delete")) {
        actionUsrArticleDelete(rq);

      }


      else if(rq.getUrlPath().equals("exit")) {
        System.out.println("프로그램을 종료합니다.");
        break;
      }
    }

    sc.close();
  }

  private static void actionUsrArticleWrite(Scanner sc) {
    System.out.println("== 게시물 등록 ==");
    System.out.printf("제목 : ");
    String title = sc.nextLine();

    System.out.printf("내용 : ");
    String content = sc.nextLine();

    int id = articleLastId + 1;
    articleLastId = id;

    Article article = new Article(id, title, content);

    articles.add(article); // list에 게시물 추가

    System.out.printf("%d번 게시물이 등록되었습니다.\n", id);
  }

  private static void actionUsrArticleList(Rq rq) {
    System.out.println("== 게시물 리스트 ==");
    System.out.println("-------------------");
    System.out.println("번호 / 제목");
    System.out.println("-------------------");

    Map<String, String> params = rq.getParams();

    List<Article> filteredArticle = articles;

    if(params.containsKey("searchKeyword")) {
      String searchKeyword = params.get("searchKeyword");

      filteredArticle = new ArrayList<>();

      for(Article article : articles) {
        boolean matched = article.title.contains(searchKeyword) || article.content.contains(searchKeyword);

        if(matched) {
          filteredArticle.add(article);
        }
      }
    }

    List<Article> sortedArticles = filteredArticle;

    boolean orderByIdDesc = true;

    if(params.containsKey("orderBy") && params.get("orderBy").equals("idAsc")) {
      orderByIdDesc = false;
    }

    if(orderByIdDesc) {
      sortedArticles = Util.reverseList(sortedArticles);
    }
    sortedArticles.stream()
        .forEach(article -> System.out.printf("%d / %s\n", article.id, article.title));
  }

  private static void actionUsrArticleDetail(Rq rq) {
    Map<String, String> params = rq.getParams();

    if(params.containsKey("id") == false) {
      System.out.println("id를 입력해주세요.");
      return;
    }

    int id = 0;

    try {
      id = Integer.parseInt(params.get("id"));
    } catch (NumberFormatException e) {
      System.out.println("id를 정수 형태로 입력해주세요.");
      return;
    }

    // 게시물이 아예 없는 경우
    if(articles.isEmpty()) {
      System.out.println("게시물이 존재하지 않습니다.");
      return;
    }

    // 내가 입력한 id가 현재 게시물에 수량을 초과한 경우
    if(id > articles.size()) {
      System.out.println("해당 게시물은 존재하지 않습니다.");
      return;
    }

    Article foundArticle = null;

    for(Article article : articles) {
      if(article.id == id) {
        foundArticle = article;
        break;
      }
    }

    if(foundArticle == null) {
      System.out.println("해당 게시물은 존재하지 않습니다.");
      return;
    }

    System.out.println("== 게시물 상세보기 ==");
    System.out.printf("번호 : %d\n", foundArticle.id);
    System.out.printf("제목 : %s\n", foundArticle.title);
    System.out.printf("내용 : %s\n", foundArticle.content);
  }

  private static void actionUsrAtticleModify(Scanner sc, Rq rq) {
    Map<String, String> params = rq.getParams();

    if(params.containsKey("id") == false) {
      System.out.println("id를 입력해주세요.");
      return;
    }

    int id = 0;

    try {
      id = Integer.parseInt(params.get("id"));
    } catch (NumberFormatException e) {
      System.out.println("id를 정수 형태로 입력해주세요.");
      return;
    }

    if(articles.isEmpty() || id > articles.size()) {
      System.out.println("게시물이 존재하지 않습니다.");
      return;
    }

    Article foundArticle = null;

    for(Article article : articles) {
      if(article.id == id) {
        foundArticle = article;
        break;
      }
    }

    if(foundArticle == null) {
      System.out.println("해당 게시물은 존재하지 않습니다.");
      return;
    }

    System.out.printf("새 제목 : ");
    foundArticle.title = sc.nextLine();
    System.out.printf("새 내용 :");
    foundArticle.content = sc.nextLine();

    System.out.printf("%d번 게시물이 수정되었습니다.\n", foundArticle.id);
  }

  private static void actionUsrArticleDelete(Rq rq) {
    Map<String, String> params = rq.getParams();

    if(params.containsKey("id") == false) {
      System.out.println("id를 입력해주세요.");
      return;
    }

    int id = 0;

    try {
      id = Integer.parseInt(params.get("id"));
    } catch (NumberFormatException e) {
      System.out.println("id를 정수 형태로 입력해주세요.");
      return;
    }

    if(articles.isEmpty() || id > articles.size()) {
      System.out.println("게시물이 존재하지 않습니다.");
      return;
    }

    Article foundArticle = null;

    for(Article article : articles) {
      if(article.id == id) {
        foundArticle = article;
        break;
      }
    }

    if(foundArticle == null) {
      System.out.println("해당 게시물은 존재하지 않습니다.");
      return;
    }

    articles.remove(foundArticle);
    System.out.printf("%d번 게시물이 삭제되었습니다.\n", id);
  }
}