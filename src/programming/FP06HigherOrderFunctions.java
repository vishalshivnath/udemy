package programming;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FP06HigherOrderFunctions {


    public static void main(String[] args) {
        List<Course> courses= List.of(
                new Course("Spring","Framework",98,2000),
                new Course("Java","Framework",96,500),
                new Course("Python","Language",90,2000),
                new Course("API","Microservices",100,2000),
                new Course("Microservices","Microservices",80,6000),
                new Course("AWS","Cloud",90,6000),
                new Course("Docker","Cloud",100,6000),
                new Course("Kubernetes","Cloud",70,6000)
        );


        //AllMatch
       // int cutOffReviewScore=95;
        Predicate<Course> reviewScoreGreatorThan95 = createMethodWithCutoffReviewScore(95);
        Predicate<Course> reviewScoreGreatorThan90 = createMethodWithCutoffReviewScore(90);
       // Predicate<Course> reviewScoreLessThan90 = course -> course.getReviewScore() < 90;


    }

    private static Predicate<Course> createMethodWithCutoffReviewScore(int cutOffReviewScore) {
        return course -> course.getReviewScore() > cutOffReviewScore;
    }

   // jshell> courses.stream().filter(course -> course.length() >9).map(String::toUpperCase).findFirst()
   // $34 ==> Optional[SPRING BOOT]

    //jshell> courses.stream().peek(System.out::println).filter(course -> course.length() >9).map(String::toUpperCase).peek(System.out::println).findFirst()
    //Spring
    //Spring Boot
    //SPRING BOOT
    //$35 ==> Optional[SPRING BOOT]
}
