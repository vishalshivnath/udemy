package  programming;

import java.util.List;

public class FP01Structured {


    public static void main(String[] args) {
        printAllNumbersInListStructured(List.of(3,4,12,7,1,2,12,15));
    }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {
        //how to loop the numbers
        for(int number:numbers){
            System.out.println(number);
        }
    }


}
