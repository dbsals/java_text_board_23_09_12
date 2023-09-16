package com.ym.exam.board;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    String queryString = "a=1&b=2&c=3";

    String[] queryStringbits = queryString.split("&");

    //향상된 for문
    /*
    for(String bit : queryStringbits){
      System.out.println(bit);
    }
    */

    //stream
    Arrays.stream(queryStringbits)
        .forEach(System.out::println);
  }
}
