package functional;

import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {


    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 4, 12, 7, 1, 2, 12, 15);
        List<String> courses=List.of("Spring","Spring Boot","API" ,"Microservices","AWS","Azure","Docker","Kubernetes");

        int sum=addListUsingStructuredApproach(numbers);
        System.out.println(sum);

        List<Integer> doubledNumbers=doubledList(numbers);
        System.out.println(doubledNumbers);

        List<Integer> EvenNumberList=EvenNumbersList(numbers);
        System.out.println(EvenNumberList);
    }


    private  static int sum(int agreegate, int nextNumber){
        System.out.println(agreegate+" "+nextNumber);
        return agreegate+nextNumber;
    }

    private static int addListUsingStructuredApproach(List<Integer> numbers){

        return numbers.stream().
                //reduce(0,FP02Functional::sum);
               // reduce(0,(aggregate,nextNumber)->aggregate+nextNumber);  //Lambda expression
                    reduce(0,Integer::sum);   //method reference
    }


    private static List<Integer> doubledList(List<Integer> numbers){
        return numbers.stream()
                .map(x->x*x).collect(Collectors.toList());
    }

    private static List<Integer> EvenNumbersList(List<Integer> numbers){
        return numbers.stream()
                .filter(x->x%2 ==0).collect(Collectors.toList());
    }


   /* private static List<Integer> EvenNumbersList(List<Integer> numbers){
        return numbers.stream()
                .filter(x->x%2 ==0).collect(Collectors.toList());
    }*/
}
