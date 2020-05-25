package functional;

import java.util.List;

//https://github.com/in28minutes/functional-programming-with-java
public class FP01Functional {


    public static void main(String[] args) {
        final  List<String> courses=List.of("Spring","Spring Boot","API" ,"Microservices","AWS","Azure","Docker","Kubernetes");
        final List<Integer> numbers = List.of(3, 4, 12, 7, 1, 2, 13, 15, 89);
        //printAllNumbersInListFunctional(numbers);
        printEvenNumbersInListFunctional(numbers);
        printOddNumbersInListFunctional(numbers);
        printEvenNumbersSquareInListFunctional(numbers);
        printAllCoursesInListFunctional(courses);
        printFilteredCoursesInListFunctional(courses);
        printFilteredCourses2InListFunctional(courses);
        printCourseLengthListFunctional(courses);

    }

    private static void print(int number){
        System.out.println(number);
    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {


        //[ 3,4,12,7,1,2,12,15]
        //3
        //4
        //12

        //what to do
        numbers.stream().forEach(FP01Functional::print); //method reference
        //how to loop the numbers

        numbers.stream().forEach(System.out::println);


    }

    //number -> number%2 ==2
    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
        System.out.println("printEvenNumbersInListFunctional -->");
        //Filter -only allow even numbers
        numbers.stream().
                filter(number -> number%2 == 0).   //Lambda expression-simpler way of defining method
                forEach(System.out::println);      //Method reference

    }

    //number -> number%2 ==2
    private static void printOddNumbersInListFunctional(List<Integer> numbers) {
        System.out.println("printOddNumbersInListFunctional -->");
        numbers.stream().
                filter(number -> number%2 != 0).   //Lambda expression-simpler way of defining method
                forEach(System.out::println);      //Method reference

    }

    //number -> number%2 ==2
    private static void printEvenNumbersSquareInListFunctional(List<Integer> numbers) {
        System.out.println("printEvenNumbersSquareInListFunctional -->");
        numbers.stream()
                .filter(number -> number%2 == 0)   //Lambda expression-simpler way of defining method
                .map(number -> number * number)
                .forEach(System.out::println);      //Method reference

    }

    private  static void printAllCoursesInListFunctional(List<String> courses){
        System.out.println("printAllCoursesInListFunctional -->");
        courses.stream().forEach(System.out::println);
    }

    private  static void printFilteredCoursesInListFunctional(List<String> courses){
        System.out.println("printFilteredCoursesInListFunctional -->");
        courses.stream().
                filter(course->course.contains("Spring")).
                forEach(System.out::println);
    }

    private  static void printFilteredCourses2InListFunctional(List<String> courses){
        System.out.println("printFilteredCourses2InListFunctional -->");
        courses.stream().
                filter(course->course.length()>4).
                forEach(System.out::println);
    }

    private  static void printCourseLengthListFunctional(List<String> courses){
        System.out.println("printCourseLengthListFunctional -->");
        courses.stream()
                .map(course -> course + "->" + course.length())
                .forEach(System.out::println);
    }

}
