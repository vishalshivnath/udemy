package programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course{

    private String name;
    private  String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", reviewScore=" + reviewScore +
                ", noOfStudents=" + noOfStudents +
                '}';
    }
}
public class FP04CustomClass {

    public static void main(String[] args) {

        List<Course> courses= List.of(
                new Course("Spring","Framework",98,2000),
                new Course("Java","Framework",80,500),
                new Course("Python","Language",90,2000),
                new Course("API","Microservices",100,2000),
                new Course("Microservices","Microservices",80,6000),
                new Course("AWS","Cloud",90,6000),
                new Course("Docker","Cloud",100,6000),
                new Course("Kubernetes","Cloud",70,6000)
        );

        //AllMatch
        Predicate<Course> reviewScoreGreatorThan75 = course -> course.getReviewScore() > 70;
        Predicate<Course> reviewScoreGreatorThan90 = course -> course.getReviewScore() > 90;
        Predicate<Course> reviewScoreLessThan90 = course -> course.getReviewScore() < 90;

        System.out.println(
        courses.stream()
                .allMatch(reviewScoreGreatorThan75));
        //None Match
        System.out.println(
                courses.stream()
                        .noneMatch(reviewScoreGreatorThan90));

        System.out.println(
                courses.stream()
                        .noneMatch(reviewScoreLessThan90));
        //AnyMatch
        System.out.println(
                courses.stream()
                        .anyMatch(reviewScoreLessThan90));

        System.out.println(
                courses.stream()
                        .anyMatch(reviewScoreGreatorThan90));

        //Sort in ascending order
        Comparator<Course> comparingNoOfStudents=Comparator.comparing(Course::getNoOfStudents);
        System.out.println(courses.stream().sorted(comparingNoOfStudents).collect(Collectors.toList()));


        //Sort in descending order
        Comparator<Course> comparingNoOfStudentsInDescreasingOrder=Comparator.comparing(Course::getNoOfStudents).reversed();
        System.out.println(courses.stream().sorted(comparingNoOfStudentsInDescreasingOrder).collect(Collectors.toList()));

        //Sort in ascending order for two fields
        Comparator<Course> comparingNoOfStudentsAndNumberOfReviews=Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore).reversed();
        System.out.println(courses.stream().sorted(comparingNoOfStudentsAndNumberOfReviews).collect(Collectors.toList()));

        //Skip
        System.out.println(courses.stream().sorted(comparingNoOfStudentsAndNumberOfReviews).skip(3).collect(Collectors.toList()));

        //Limit
        System.out.println(courses.stream().sorted(comparingNoOfStudentsAndNumberOfReviews).limit(5).collect(Collectors.toList()));

        //Skip and Limit
        System.out.println(courses.stream().sorted(comparingNoOfStudentsAndNumberOfReviews).skip(2).limit(2).collect(Collectors.toList()));

        //TakeWhile
        System.out.println(courses.stream().takeWhile(course -> course.getReviewScore() >=95).collect(Collectors.toList()));

        //Sorted and Take While
        Comparator<Course> comparingByNumberOfReviews=Comparator.comparing(Course::getReviewScore).reversed();
        System.out.println(courses.stream().sorted(comparingByNumberOfReviews).takeWhile(course -> course.getReviewScore() >=95).collect(Collectors.toList()));

        //DropWhile
        System.out.println("DropWhile --> "+courses.stream().dropWhile(course -> course.getReviewScore() >=95).collect(Collectors.toList()));

        //Max
        System.out.println("Max Score --> "+courses.stream().max(comparingNoOfStudentsAndNumberOfReviews));

        //Min
        System.out.println("Min Score --> "+courses.stream().min(comparingNoOfStudentsAndNumberOfReviews));
        System.out.println("Min Score --> "+courses.stream().min(comparingNoOfStudentsAndNumberOfReviews).orElse(new Course("Kubernetes","Cloud",70,6000)));

        //Handle Null Vaues
        System.out.println("Optional --> "+courses.stream().filter(reviewScoreLessThan90).min(comparingNoOfStudentsAndNumberOfReviews).orElse(new Course("Kubernetes","Cloud",70,6000)));

        //FindFirst
        System.out.println("FindFirst --> "+courses.stream().filter(reviewScoreLessThan90).findFirst());
        System.out.println("FindFirst --> "+courses.stream().filter(reviewScoreGreatorThan75).findFirst());

        //FindAny
        System.out.println("FindAny --> "+courses.stream().filter(reviewScoreLessThan90).findAny());

        //Sum
        System.out.println("Sum --> "+courses.stream().filter(reviewScoreGreatorThan90).mapToInt(Course::getNoOfStudents).sum()); //10000

        //Count
        System.out.println("Count --> "+courses.stream().filter(reviewScoreGreatorThan90).mapToInt(Course::getNoOfStudents).count()); //3

        System.out.println("Count --> "+courses.stream().filter(reviewScoreGreatorThan90).count()); //3

        //Average
        System.out.println("Average --> "+courses.stream().filter(reviewScoreGreatorThan90).mapToInt(Course::getNoOfStudents).average()); //OptionalDouble[3333.333]

        //Max
        System.out.println("MAX --> "+courses.stream().filter(reviewScoreGreatorThan90).mapToInt(Course::getNoOfStudents).max()); //OptionalInt[6000]

        //Min
        System.out.println("MIN --> "+courses.stream().filter(reviewScoreGreatorThan90).mapToInt(Course::getNoOfStudents).min()); //ptionalInt[2000]

        //HashMap group by category
        System.out.println("Group --> "+courses.stream().collect(Collectors.groupingBy(Course::getCategory)));
        //Group --> {Language=[Course{name='Python', category='Language', reviewScore=90, noOfStudents=2000}], Cloud=[Course{name='AWS', category='Cloud', reviewScore=90, noOfStudents=6000}, Course{name='Docker', category='Cloud', reviewScore=100, noOfStudents=6000}, Course{name='Kubernetes', category='Cloud', reviewScore=70, noOfStudents=6000}], Microservices=[Course{name='API', category='Microservices', reviewScore=100, noOfStudents=2000}, Course{name='Microservices', category='Microservices', reviewScore=80, noOfStudents=6000}], Framework=[Course{name='Spring', category='Framework', reviewScore=98, noOfStudents=2000}, Course{name='Java', category='Framework', reviewScore=80, noOfStudents=500}]}

        System.out.println("Group --> "+courses.stream().collect(Collectors.groupingBy(Course::getCategory,Collectors.counting())));
        //Group --> {Language=1, Cloud=3, Microservices=2, Framework=2}

        //Course with highest reviews
        System.out.println("Group --> "+courses.stream().collect(Collectors.groupingBy(Course::getCategory,Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
        //Group --> {Language=Optional[Course{name='Python', category='Language', reviewScore=90, noOfStudents=2000}], Cloud=Optional[Course{name='Docker', category='Cloud', reviewScore=100, noOfStudents=6000}], Microservices=Optional[Course{name='API', category='Microservices', reviewScore=100, noOfStudents=2000}], Framework=Optional[Course{name='Spring', category='Framework', reviewScore=98, noOfStudents=2000}]}

        //List of names of courses
        System.out.println("Group --> "+courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.mapping(Course::getName,Collectors.toList()))));
        //Group --> {Language=[Python], Cloud=[AWS, Docker, Kubernetes], Microservices=[API, Microservices], Framework=[Spring, Java]}

        //jshell> LongStream.rangeClosed(1,50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE,BigInteger::multiply)
        //$21 ==> 30414093201713378043612608166064768844377641568960512000000000000

    }


}
