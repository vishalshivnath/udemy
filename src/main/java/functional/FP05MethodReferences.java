package functional;

import java.util.List;
import java.util.function.*;

public class FP05MethodReferences {


    public static void main(String[] args) {
        List<String> courses=List.of("Spring","Spring Boot","API" ,"Microservices","AWS","Azure","Docker","Kubernetes");

        courses.stream()
                //.map(str ->str.toUpperCase())
                .map(String::toUpperCase)
                .forEach(System.out::println);

        //Supplier<String> supplier = ()->new String();
        Supplier<String> supplier = String::new;


        //courses.stream().collect(Collectors.joining(" "))

        //courses.stream().map(course->course.split("")).flatMap(Arrays::stream).collect(Collectors.toList())
        //$29 ==> [S, p, r, i, n, g, S, p, r, i, n, g,  , B, o, o, t, A, P, I, M, i, c, r, o, s, e, r, v, i, c, e, s, A, W, S, A, z, u, r, e, D, o, c, k, e, r, K, u, b, e, r, n, e, t, e, s]

    }



}
