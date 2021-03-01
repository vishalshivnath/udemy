package functional;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03BehaviorParameterization {


    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 4, 12, 7, 1, 2, 12, 15);

        filterAndPrint(numbers, x1 -> x1 % 2 == 0);

        filterAndPrint(numbers, x -> x % 2 != 0);

        filterAndPrint(numbers, x -> x % 3 == 0);

        mapAndPrint(numbers,x->x*x);

        mapAndPrint(numbers,x->x*x*x);

    }

    //We are passing the code/behavior as parameter to Java function

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {

        numbers.stream().filter(predicate).forEach(System.out::println);

    }


    private static List<Integer> mapAndPrint(List<Integer> numbers, Function<Integer, Integer> function) {

        List<Integer> listOfNumber=numbers.stream().map(function).collect(Collectors.toList());
        System.out.println(listOfNumber);
        return listOfNumber;

    }


}
