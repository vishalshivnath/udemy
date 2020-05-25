package functional;

import java.util.List;
import java.util.stream.LongStream;

public class FP07ParallelProgramming {


    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Spring", "Framework", 98, 2000),
                new Course("Java", "Framework", 96, 500),
                new Course("Python", "Language", 90, 2000),
                new Course("API", "Microservices", 100, 2000),
                new Course("Microservices", "Microservices", 80, 6000),
                new Course("AWS", "Cloud", 90, 6000),
                new Course("Docker", "Cloud", 100, 6000),
                new Course("Kubernetes", "Cloud", 70, 6000)
        );

        long time=System.currentTimeMillis();
        System.out.println(LongStream.range(0, 1000000200).sum());
        System.out.println(System.currentTimeMillis()-time);

        long time2=System.currentTimeMillis();
        System.out.println(LongStream.range(0, 1000000200).parallel().sum());
        System.out.println(System.currentTimeMillis()-time2);

    }

}
