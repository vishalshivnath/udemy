package java8features;

public class PersonImpl {

  public static void main(String[] args) {
    PersonInterface<Person> personFactory=(P,T)->new Person(P,T);

    System.out.println(personFactory.create("John","Abram").toString());

    PersonInterface<Person> personFactory2=Person::new;

    System.out.println(personFactory2.create("Amit","Json").toString());

  }
}

@FunctionalInterface
interface PersonInterface<P extends Person>{
  P create(String firstName,String lastName);
}

class  Person {
  String firstName;
  String lastName;

  Person() {}

  Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "Person{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + '}';
  }
}