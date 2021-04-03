package generics.samples;

import java.util.ArrayList;
import java.util.List;

public class GenericsSamples {

  public static void main(String[] args) {

    List<String> list1 = new ArrayList<String>(); // java 7 ? List<String> list1 = new ArrayList<>();
    list1.add("abc");
    //list1.add(new Integer(5)); //compiler error

    for(String str : list1){
      //no type casting needed, avoids ClassCastException
    }

    GenericsType<String> genericsType=new GenericsType<>();
    genericsType.set("hello");
    System.out.println(genericsType.get());

    GenericsType<String> genericsType2=new GenericsType<>();
    genericsType2.set("hello");
    System.out.println(genericsType2.get());

    System.out.println("Are two objects equal : "+GenericsSamples.<String>isEqual(genericsType,genericsType2));
    System.out.println("Are two objects equal : "+GenericsSamples.isEqual(genericsType,genericsType2));

    System.out.println("Are two integer objects equal : "+GenericsSamples.isEqualTo(2,3));

    System.out.println("Are two integer objects equal : "+GenericsSamples.compare("two","One"));


    String str = "abc";
    Object obj = new Object();
    obj=str; // works because String is-a Object, inheritance in java

    MyClass<String> stringMyClass=new MyClass<>();
    MyClass<Object> objectMyClass=new MyClass<>();

    //stringMyClass=objectMyClass; // compilation error since MyClass<String> is not a MyClass<Object>
    obj = stringMyClass; // MyClass<T> parent is Object

    List<? extends Integer> intList = new ArrayList<>();
    List<? extends Number>  numList = intList;  // OK. List<? extends Integer> is a subtype of List<? extends Number>

  }


  public static <T> boolean isEqual(GenericsType<T> T1,GenericsType<T> T2){
    return  T1.get().equals(T2.get());
  }

  public static <T extends Integer> boolean isEqualTo(T T1,T T2){
    return  T1==T2;
  }

  public static <T extends Comparable<T>> int compare(T T1,T T2){
     return T1.compareTo(T2);
  }


}
