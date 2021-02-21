package java8features;

public class ConvertorImpl {

  public static void main(String[] args) {
    ConvertorInterface<String, Integer> converter = (from) -> Integer.valueOf(from);
    Integer converted = converter.convert("123");
    System.out.println(converted);    // 123

    ConvertorInterface<String, Integer> converter2 = Integer::valueOf;
    Integer converted2 = converter2.convert("123");
    System.out.println(converted2);    // 123

    Something something = new Something();
    ConvertorInterface<String, String> converter3=something::startsWith;
    String converted3 = converter3.convert("Java");
    System.out.println(converted3);    // "J"
  }

  static class Something {
    String startsWith(String s) {
      return String.valueOf(s.charAt(0));
    }
  }


}

