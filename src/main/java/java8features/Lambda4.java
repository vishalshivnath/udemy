package java8features;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda4 {

  static int outerStaticNum;
  int outerNum;

  void testScopes() {
    ConvertorInterface<Integer, String> stringConverter1 = (from) -> {
      outerNum = 23;
      return String.valueOf(from);
    };

    ConvertorInterface<Integer, String> stringConverter2 = (from) -> {
      outerStaticNum = 72;
      return String.valueOf(from);
    };
  }

  public static void main(String[] args) {

    Predicate<Integer> predicateObj=(a)->a%2==0;
    System.out.println(predicateObj.test(1));
    System.out.println(predicateObj.negate().test(1));


    Predicate<String> predicateString=(a)->a.length()>0;
    System.out.println(predicateString.test("abc"));
    System.out.println(predicateString.negate().test("abc"));

    Predicate<Boolean> nonNull = Objects::nonNull;
    Predicate<Boolean> isNull = Objects::isNull;

    Predicate<String> isEmpty = String::isEmpty;
    Predicate<String> isNotEmpty = isEmpty.negate();

    Function<String, Integer> toInteger = Integer::valueOf;
    Function<String, String> backToString = toInteger.andThen(String::valueOf);

    backToString.apply("123");     // "123"

    Supplier<Person> personSupplier = Person::new;
    personSupplier.get();   // new Person

    Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
    greeter.accept(new Person("Luke", "Skywalker"));

    Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

    Person p1 = new Person("John", "Doe");
    Person p2 = new Person("Alice", "Wonderland");

    comparator.compare(p1, p2);             // > 0
    comparator.reversed().compare(p1, p2);  // < 0

    Optional<String> optional = Optional.of("bam");

    optional.isPresent();           // true
    optional.get();                 // "bam"
    optional.orElse("fallback");    // "bam"

    optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"

    List<String> stringCollection = new ArrayList<>();
    stringCollection.add("ddd2");
    stringCollection.add("aaa2");
    stringCollection.add("bbb1");
    stringCollection.add("aaa1");
    stringCollection.add("bbb3");
    stringCollection.add("ccc");
    stringCollection.add("bbb2");
    stringCollection.add("ddd1");

    stringCollection
        .stream()
        .filter((s) -> { System.out.println(s) ; return s.startsWith("a") ;})
        .forEach(System.out::println);

    // "aaa2", "aaa1"

    stringCollection
        .stream()
        .sorted()
        .filter((s) -> s.startsWith("a"))
        .forEach(System.out::println);

    // "aaa1", "aaa2"
    System.out.println(stringCollection);

    stringCollection
        .stream()
        .map(String::toUpperCase)
        .sorted((a, b) -> b.compareTo(a))
        .forEach(System.out::println);

    // "DDD2", "DDD1", "CCC", "BBB3", "BBB2", "AAA2", "AAA1"

    boolean anyStartsWithA =
        stringCollection
            .stream()
            .anyMatch((s) -> s.startsWith("a"));

    System.out.println(anyStartsWithA);      // true

    boolean allStartsWithA =
        stringCollection
            .stream()
            .allMatch((s) -> s.startsWith("a"));

    System.out.println(allStartsWithA);      // false

    boolean noneStartsWithZ =
        stringCollection
            .stream()
            .noneMatch((s) -> s.startsWith("z"));

    System.out.println(noneStartsWithZ);      // true

    long startsWithB =
        stringCollection
            .stream()
            .filter((s) -> s.startsWith("b"))
            .count();

    System.out.println(startsWithB);    // 3

    Optional<String> reduced =
        stringCollection
            .stream()
            .sorted()
            .reduce((s1, s2) -> s1 + "#" + s2);

    reduced.ifPresent(System.out::println);
    // "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"



    int max = 10000000;
    List<String> values = new ArrayList<>(max);
    for (int i = 0; i < max; i++) {
      UUID uuid = UUID.randomUUID();
      values.add(uuid.toString());
    }

    long t0 = System.nanoTime();

    long count = values.stream().sorted().count();
    System.out.println(count);

    long t1 = System.nanoTime();

    long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
    System.out.println(String.format("sequential sort took: %d ms", millis));

    // sequential sort took: 899 ms

    long t00 = System.nanoTime();

    long countt = values.parallelStream().sorted().count();
    System.out.println(countt);

    long t11 = System.nanoTime();

    long milliss = TimeUnit.NANOSECONDS.toMillis(t11 - t00);
    System.out.println(String.format("parallel sort took: %d ms", milliss));

    // parallel sort took: 472 ms


    Map<Integer, String> map = new HashMap<>();

    for (int i = 0; i < 10; i++) {
      map.putIfAbsent(i, "val" + i);
    }

    map.forEach((id, val) -> System.out.println(val));

    map.computeIfPresent(3, (num, val) -> val + num);
    map.get(3);             // val33

    map.computeIfPresent(9, (num, val) -> null);
    map.containsKey(9);     // false

    map.computeIfAbsent(23, num -> "val" + num);
    map.containsKey(23);    // true

    map.computeIfAbsent(3, num -> "bam");
    map.get(3);             // val33

    map.remove(3, "val3");
    map.get(3);             // val33

    map.remove(3, "val33");
    map.get(3);

    map.getOrDefault(42, "not found");  // not found

    map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
    map.get(9);             // val9

    map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
    map.get(9);             // val9concat


    Clock clock = Clock.systemDefaultZone();
    long millisss = clock.millis();

    Instant instant = clock.instant();
    Date legacyDate = Date.from(instant);   // legacy java.util.Date

    System.out.println(ZoneId.getAvailableZoneIds());
    // prints all available timezone ids

    ZoneId zone1 = ZoneId.of("Europe/Berlin");
    ZoneId zone2 = ZoneId.of("Brazil/East");
    System.out.println("zone1"+zone1.getRules());
    System.out.println("zone2"+zone2.getRules());

    // ZoneRules[currentStandardOffset=+01:00]
    // ZoneRules[currentStandardOffset=-03:00]

    Hint hint = Person2.class.getAnnotation(Hint.class);
    System.out.println(hint);                   // null

    Hints hints1 = Person2.class.getAnnotation(Hints.class);
    System.out.println(hints1.value().length);  // 2

    Hint[] hints2 = Person3.class.getAnnotationsByType(Hint.class);
    System.out.println(hints2.length);

  }
}


@interface Hints {
  Hint[] value();
}

@Repeatable(Hints.class)
@interface Hint {
  String value();
}


@Hints({@Hint("hint1"), @Hint("hint2")})
class Person2 {}

@Hint("hint1")
@Hint("hint2")
class Person3 {}

@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@interface MyAnnotation {}