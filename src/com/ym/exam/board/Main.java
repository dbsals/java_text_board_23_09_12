package com.ym.exam.board;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    String queryString1 = "id=5&title=aaa&content=bbbb&writerName=홍길동&name=[1=2]";
    Map<String, String> params1 = Util.getParams(queryString1);
    System.out.println(params1);
    System.out.printf("content : %s\n", params1.get("content"));
  }
}

class Util {
  static Map<String, String> getParams(String getStr) {
    Map<String, String> params = new HashMap<>();

    for(String bit : getStr.split("&")) {
      String[] bits = bit.split("=", 2);
      if(bits.length == 1) {
        continue;
      }

      params.put(bits[0], bits[1]);
    }

    return params;
  }
}