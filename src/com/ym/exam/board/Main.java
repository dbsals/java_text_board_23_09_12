package com.ym.exam.board;

import java.util.HashMap;
import java.util.Map;

class Main {
  public static void main(String[] args) {
    Rq rq = new Rq("/usr/article/list?page=1&searchKeyword=안녕? 어서와");

    Map<String, String> params = rq.getParams();
    System.out.println(params); // {page=1, searchKeyword=안녕? 어서와}
    System.out.println(rq.getParams()); // {page=1, searchKeyword=안녕? 어서와}
    System.out.println(rq.getParams()); // {page=1, searchKeyword=안녕? 어서와}


    String urlPath = rq.getUrlPath();
    System.out.println(urlPath); // /usr/article/list
    System.out.println(rq.getUrlPath()); // /usr/article/list
    System.out.println(rq.getUrlPath()); // /usr/article/list
  }
}

class Rq {
  String url;
  // 필드추가가능
  Map<String, String> Params;
  String urlPath;
  // 수정불가능
  Rq(String url) {
    this.url = url;
    Params = Util.getParamsFromUrl(url);
    urlPath = Util.getUrlPathFromUrl(url);
  }

  // 수정가능
  public Map<String, String> getParams() {
    return Params;
  }

  // 수정가능
  public String getUrlPath() {
    return urlPath;
  }
}

class Util {
  static Map<String, String> getParamsFromUrl(String url) {
    System.out.println("getParamsFromUrl 실행됨");
    Map<String, String> params = new HashMap<>();
    String[] urlBits = url.split("\\?", 2);

    if(urlBits.length == 1) {
      return params;
    }

    String queryStr = urlBits[1];

    for(String bit : queryStr.split("&")) {
      String[] bits = bit.split("=", 2);

      if(bits.length == 1) {
        continue;
      }

      params.put(bits[0], bits[1]); // key, value
    }

    return params;
  }

  static String getUrlPathFromUrl(String url) {
    System.out.println("getUrlPathFromUrl 실행됨");
    return url.split("\\?", 2)[0];
  }
}