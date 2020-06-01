package generics;

import java.util.Arrays;
import java.util.List;

public class Generics04UpperBoundedParameters {

    private static void add(List<? extends  Number> numberList){
        Double sum=0.0;

        for(Number num:numberList){
            sum=sum+num.doubleValue();
        }
        System.out.println("added value is -->"+sum);
    }

    public static void main(String[] args) {

        Generics04UpperBoundedParameters.add(Arrays.asList(1,5,6,545,54));
        Generics04UpperBoundedParameters.add(Arrays.asList(1.1,2.2,3.3,4.4,5.5));

    }
}
