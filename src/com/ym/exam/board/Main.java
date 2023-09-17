package com.ym.exam.board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    String queryString = "a=10&b=20&c=30&d=40";

    List<String> paramNames = new ArrayList<>();
    List<Integer> paramValues = new ArrayList<>();

    String[] queryStringbits = queryString.split("&");

    for(String bit : queryStringbits){
      String[] bitBits = bit.split("=");
      String paramName = bitBits[0];
      String paramValue = bitBits[1];

      paramNames.add(paramName);
      paramValues.add(Integer.parseInt(paramValue));

    }

    for(int i = 0; i < paramNames.size(); i++){
      System.out.printf("%s : %d\n", paramNames.get(i), paramValues.get(i));
    }
  }
}
