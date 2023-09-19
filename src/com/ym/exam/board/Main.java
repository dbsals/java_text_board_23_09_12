package com.ym.exam.board;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    String queryString1 = "id=5&title=aaa&content=bbbb&writerName=홍길동";
    String queryString2 = "id=13&name=James&age=30";
    String queryString3 = "id=13&name=James";

    Map<String, String> params1 = Util.getParams(queryString1);
    Map<String, String> params2 = Util.getParams(queryString2);
    Map<String, String> params3 = Util.getParams(queryString3);

    System.out.println(params1);
    System.out.println(params2);
    System.out.println(params3);

  }
}

class Util {
  static Map<String, String> getParams(String queryStr) {
    Map<String, String> params = new HashMap<>();

    String[] queryStrBits = queryStr.split("&");

    for(String bit : queryStrBits) {
      String[] bits = bit.split("=");

      params.put(bits[0], bits[1]);
    }
    return params;
  }
}