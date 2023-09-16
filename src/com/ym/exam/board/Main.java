package com.ym.exam.board;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    String queryString = "a=10&b=20&c=30";

    int a = 0;
    int b = 0;
    int c = 0;

    String[] queryStringbits = queryString.split("&");

    for(String bit : queryStringbits){
      String[] bitBits = bit.split("=");
      String paramName = bitBits[0];
      String paramValue = bitBits[1];

      if(paramName.equals("a")){
        a = Integer.parseInt(paramValue);
      }
      else if(paramName.equals("b")){
        b = Integer.parseInt(paramValue);
      }
      else if(paramName.equals("c")){
        c = Integer.parseInt(paramValue);
      }
    }
    System.out.printf("a : %d\n", a);
    System.out.printf("b : %d\n", b);
    System.out.printf("c : %d\n", c);

  }
}
