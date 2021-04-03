package java8features;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateSample {

  public static void main(String[] args) {

    Predicate<Integer> predicate=i->i<10;
    System.out.println(predicate.test(11));
    System.out.println(predicate.test(7));


    Predicate<String> predicate1=i->i.length()>3;
    System.out.println(predicate1.test("acbd"));
    System.out.println(predicate1.test("ab"));

    Predicate<List> predicate2=List::isEmpty;
    List<Number> list=new ArrayList<>();
    list.add(1);
    System.out.println(predicate2.test(list));

    Predicate<Collection> predicate3= c -> c.isEmpty();
    System.out.println(predicate3.test(list));

    int[] x = {0, 5, 10, 15, 20, 25, 30};
    Predicate<Integer> p1=i->i>10;
    Predicate<Integer> p2=i->i%2==0;

    m1(p1.and(p2),x);
    m1(p1.or(p2),x);
    m1(p1.negate(),x);
    //Write a predicate to check whether the given integer is greater than 10 or not.
    Predicate<Integer> predicateInt=i->i>10;
    System.out.println(predicateInt.test(11));
    System.out.println(predicateInt.test(9));

    //#-2 write a predicate to check whether the given collection is empty or not.
    Predicate<Collection> predicate4=c->c.isEmpty();

    //3.Program to display names starts with 'K' by using Predicate:
    String[] names={"shandy","kanika","kaushal","avanti" };
    Predicate<String> predicate5=i->i.startsWith("k");
    Predicate<String> predicate6=i->i.charAt(0)=='k';

    for (String name:names){
      System.out.println("name is "+name+"->"+predicate5.test(name));
      System.out.println("name is "+name+"->"+predicate6.test(name));
    }

    //4.Predicate Example to remove null values and empty strings from the given list:
    String[] names1={"shandy","kanika","kaushal","avanti" ,"" ,null};

    Predicate<String> predicate7=i-> i!=null && !i.isEmpty() && i.length()!=0;
    for (String name:names1){
      System.out.println("not null and empty name is "+name+"->"+predicate7.test(name));
    }

    //5.Program for User Authentication by using Predicate:
    Predicate<User> p = u->u.username.equals("durga")&& u.pwd.equals("java");
    Scanner sc= new Scanner(System.in);
    System.out.println("Enter User Name:");
    String username=sc.next();
    System.out.println("Enter Password:");
    String pwd=sc.next();
    User user=new User(username,pwd);
    if(p.test(user))
    {
     System.out.println("Valid user and can avail all services");
       }
     else
     {
       System.out.println("invalid user you cannot avail services");
       }
  }


  public static void m1(Predicate<Integer> p, int[] x) {
     for(int x1:x) {
       if(p.test(x1))
         System.out.println(x1);
       }
     }

}

class User
 {
     String username;
     String pwd;
     User(String username,String pwd)
     {
     this.username=username;
     this.pwd=pwd;
     }
 }



