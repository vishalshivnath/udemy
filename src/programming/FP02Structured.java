package programming;

import java.util.List;

public class FP02Structured {


    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 4, 12, 7, 1, 2, 12, 15);
        //printAllNumbersInListStructured(numbers);

        int sum=addListUsingStructuredApproach(numbers);
        System.out.println(sum);
    }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {
        //how to loop the numbers
        for(int number:numbers){
            System.out.println(number);
        }
    }

    private static int addListUsingStructuredApproach(List<Integer> numbers){

        int sum=0;
        for(int number:numbers){
            sum+=number;

        }

        return sum;
    }




}
