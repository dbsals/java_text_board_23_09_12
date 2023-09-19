package com.ym.exam.board;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Map<String, String> params = Util.getParamForomUrl("/usr/article/list?page=2&searchKeyword=안녕");
    System.out.println(params);

    String urlPath = Util.getPathFromUrl("/usr/article/list");
    System.out.println(urlPath);

    urlPath = Util.getPathFromUrl("/usr/article/list?page=2&searchKeyword=안녕");
    System.out.println(urlPath);
  }
}

class Util {
  static Map<String, String> getParamForomUrl(String url) {
    Map<String, String> Params = new HashMap<>();

    String[] urlBits = url.split("\\?", 2);

    if(urlBits.length == 1) {
      return Params;
    }
    String QueryStr = urlBits[1];

    for(String bit : QueryStr.split("&")) {
      String[] bits = bit.split("=", 2);

      if(bits.length == 1){
        continue;
      }

      Params.put(bits[0], bits[1]);
    }

    return Params;
  }

  static String getPathFromUrl(String url) {
    return url.split("\\?", 2)[0];
  }
}