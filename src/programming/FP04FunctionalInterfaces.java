package programming;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FP04FunctionalInterfaces {


    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 4, 12, 7, 1, 2, 12, 15);

        Supplier<Integer> supplier= ()->{
            Random r=new Random();
            return r.nextInt(100);
        };
        System.out.println(supplier.get());


        UnaryOperator<Integer> unaryOperator = x-> 3*x;
        System.out.println(unaryOperator.apply(7));

        BiPredicate<Integer,String> biPredicate = (number,string)->  {
            return number<10 && string.length()>5;
        };
        System.out.println(biPredicate.test( 9,"helloworld"));

        BiFunction<Integer,String,String> biFunction = (number,string)->  {
            return number +string;
        };
        System.out.println(biFunction.apply(5,"Yell"));

        BiConsumer<Integer,String> biConsumer=(integer,string)->{
            System.out.println(integer +string);
        };
        biConsumer.accept(7,"Mouse");


        IntBinaryOperator intBinaryOperator=(x,y)->x+y;
        System.out.println(intBinaryOperator.applyAsInt(4,5));

    }



}
