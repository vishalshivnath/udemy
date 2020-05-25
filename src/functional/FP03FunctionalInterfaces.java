package functional;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03FunctionalInterfaces {


    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 4, 12, 7, 1, 2, 12, 15);

        numbers.stream().
                filter(x->x%2==0).   //Lambda expression -> Logic
                map(x->x*x).         //Lambda expression -> Logic
                forEach(System.out::println); //Static function


        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;

        Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {

                return integer%2==0;
            }
        };


        Function<Integer, Integer> squareFunction = x -> x * x;

        Function<Integer, Integer> squareFunction2 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * integer;
            }
        };


        Consumer<Integer> sysoutConsumer = System.out::println;

        Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };

        numbers.stream().
                filter(isEvenPredicate).   //Lambda expression -> Logic
                map(squareFunction).         //Lambda expression -> Logic
                forEach(sysoutConsumer); //Static function


        numbers.stream().
                filter(isEvenPredicate2).   //Lambda expression -> Logic
                map(squareFunction2).         //Lambda expression -> Logic
                forEach(sysoutConsumer2); //Static function


        BinaryOperator<Integer> sumBinaryOperator = Integer::sum;

        BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer +integer2;
            }
        };

        numbers.stream().reduce(0,
                sumBinaryOperator);

        numbers.stream().reduce(0,
                sumBinaryOperator2);
    }



}
