package java8features;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamExamples {

  public static void main(String[] args) {

    /*Stream<String> stringStream=Stream.empty();

    Collection<String> stringCollection= Arrays.asList("abc","cde","efg");
    Stream<String> stringStream1=stringCollection.stream();

    Stream<String> streamOfArray = Stream.of("a", "b", "c");

    String[] arr = new String[]{"a", "b", "c"};
    Stream<String> streamOfArrayFull = Arrays.stream(arr);
    Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);

    Stream<String> streamBuilder =
        Stream.<String>builder().add("a").add("b").add("c").build();

    Stream<String> streamGenerated =
        Stream.generate(() -> "element").limit(10);

    Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);

    IntStream intStream = IntStream.range(1, 3);
    LongStream longStream = LongStream.rangeClosed(1, 3);

    Random random = new Random();
    DoubleStream doubleStream = random.doubles(3);

    IntStream streamOfChars = "abc".chars();
    Stream<String> streamOfString =
        Pattern.compile(", ").splitAsStream("a, b, c");

    Path path = Paths.get("C:\\file.txt");
    Stream<String> streamOfStrings = Files.lines(path);
    Stream<String> streamWithCharset =
        Files.lines(path, Charset.forName("UTF-8"));


    Stream<String> stream =
        Stream.of("a", "b", "c").filter(element -> element.contains("b"));
    Optional<String> anyElement = stream.findAny();
    Optional<String> firstElement = stream.findFirst();

    List<String> elements =
        Stream.of("a", "b", "c").filter(element -> element.contains("b"))
            .collect(Collectors.toList());
    Optional<String> anyElement2 = elements.stream().findAny();
    Optional<String> firstElement2 = elements.stream().findFirst();
*/

    Stream.of("abcd", "bbcd", "cbcd").skip(1).forEach(System.out::println);
    Stream.of("abcd", "bbcd", "cbcd").skip(1).map(p->p.substring(0,2)).forEach(System.out::println);

    List<String> list = Arrays.asList("cd12","cd21","abc1", "abc2", "abc3","abc4");
    list.stream().map(p->p.substring(0,4)).sorted().forEach(System.out::println);


    Optional<String> stream = list.stream().filter(element -> {
      System.out.println("filter() was called");
      return element.contains("2");
    }).map(element -> {
      System.out.println("map() was called:"+element);
      return element.toUpperCase();
    }).findFirst();

    System.out.println(IntStream.range(1,4).reduce((a,b)->(a+b)));


    int reducedTwoParams =
        IntStream.range(1, 4).reduce(10, (a, b) -> a + b);
    System.out.println(reducedTwoParams);


    int reducedParams = Stream.of(1, 2, 3)
        .reduce(10, (a, b) -> a + b, (a, b) -> {
          System.out.println("combiner was called");
          return a + b;
        });
    System.out.println(reducedParams);

    int reducedParallel = Arrays.asList(1, 2, 3).parallelStream()
        .reduce(10, (a, b) -> a + b, (a, b) -> {
          System.out.println("combiner was called");
          return a + b;
        });
    System.out.println(reducedParallel);


    /*String value = null;
    String result = "";
    try {
      result = value.toUpperCase();
    } catch (NullPointerException exception) {
      throw new CustomException();
    }*/

    /*String value=null;
    Optional<String> stringOptional=Optional.ofNullable(value);
    stringOptional.orElseThrow(new Exception()).toUpperCase();*/

    List<String> stringList = new ArrayList<String>();

    stringList.add("ONE");
    stringList.add("TWO");
    stringList.add("THREE");

    Stream<String> streamone = stringList.stream();

    long count = streamone
        .map((value) ->  value.toLowerCase())
        .count();

    System.out.println("count = " + count);


    List<String> stringList2 = new ArrayList<String>();

    stringList2.add("One flew over the cuckoo's nest");
    stringList2.add("To kill a muckingbird");
    stringList2.add("Gone with the wind");

    Stream<String> streamString = stringList2.stream();

    streamString.flatMap((value) -> {
      String[] split = value.split(" ");
      return (Stream<String>) Arrays.asList(split).stream();
    })
        .forEach((value) -> System.out.println(value))
    ;

    ArrayList<Integer> myNumbers = new ArrayList<Integer>();
    myNumbers.add(10);
    myNumbers.add(15);
    myNumbers.add(20);
    myNumbers.add(25);

    System.out.println(myNumbers.stream().filter(n->n>15).mapToInt(i->i).sum());

    Stream<List<String>> namesOriginalList = Stream.of(
        Arrays.asList("Pankaj"),
        Arrays.asList("David", "Lisa"),
        Arrays.asList("Amit"));
    //flat the stream from List<String> to String stream
    Stream<String> flatStream = namesOriginalList
        .flatMap(strList -> strList.stream());

    flatStream.forEach(System.out::println);
  }

  public Stream<String> streamOf(List<String> list) {
    return list == null || list.isEmpty() ? Stream.empty() : list.stream();
  }
}
