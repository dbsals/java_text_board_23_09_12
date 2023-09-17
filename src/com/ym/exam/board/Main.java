package com.ym.exam.board;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    String queryString = "id=5&title=aaa&content=bbbb&writerName=홍길동";

    Map<String, String> params = new HashMap<>();

    String[] queryStringbits = queryString.split("&");

    for(String bit : queryStringbits){
      String[] bitBits = bit.split("=");
      params.put(bitBits[0], bitBits[1]);

    }
    System.out.println("==원하는 것 하나하나 가져와서 사용");
    System.out.printf("id : %d\n", Integer.parseInt(params.get("id")));
    System.out.printf("title : %s\n", params.get("title"));
    System.out.printf("content : %s\n", params.get("content"));
    System.out.printf("writeName : %s\n", params.get("writerName"));

    System.out.println("== 반복문으로 전체 출력 ==");
    for(String paramName : params.keySet()){
      String paramValue = params.get(paramName);
      System.out.printf("%s : %s\n", paramName, paramValue);

    }
  }
}
