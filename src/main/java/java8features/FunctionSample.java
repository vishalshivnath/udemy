package java8features;

import java.util.function.Function;

public class FunctionSample {

  public static void main(String[] args) {

    Function<String,Integer> function=(s)->s.length();
    System.out.println(function.apply("abcd"));
  }
}
