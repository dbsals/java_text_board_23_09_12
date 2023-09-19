package com.ym.exam.board;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Rq rq = new Rq("/usr/article/list?page=1&searchKeyword=안녕? 어서와");

    Map<String, String> params = rq.getParams();
    System.out.println(params);

    params = rq.getParams();
    System.out.println(params);

    String urlPath = rq.getUrlPath();
    System.out.println(urlPath);

    urlPath = rq.getUrlPath();
    System.out.println(urlPath);
  }
}

class Rq {
  String url;

  public Rq(String url){
    this.url = url;
  }

  public Map<String, String> getParams(){
    return Util.getParamsForomUrl(url);
  }

  public String getUrlPath(){
    return Util.getPathFromUrl(url);
  }

}

class Util {
  static Map<String, String> getParamsForomUrl(String url) {
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