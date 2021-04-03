package java8features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaExpressionForCollections {

  public static void main(String[] args) {

    List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

    Collections.sort(names, new Comparator<String>() {
      @Override
      public int compare(String a, String b) {
        return b.compareTo(a);
      }
    });

    //Lambda Expression
    Collections.sort(names,(String a ,String b)->{return a.compareTo(b);});

    Collections.sort(names,(String a,String b)->a.compareTo(b));

    Collections.sort(names,(a,b)->a.compareTo(b));

    //Functional Interfaces


    ArrayList<Integer> l= new ArrayList<Integer>();
    l.add(10);
    l.add(0);
    l.add(15);
     l.add(5);
     l.add(20);
     System.out.println("Before Sorting:"+l);
    System.out.println(l.stream().sorted((a,b)->a.compareTo(b)).collect(Collectors.toList()));

    Collections.sort(l,(a,b)->(a>b)?-1:a<b?1:0);
    System.out.println("After sorting"+l);


     TreeSet<Integer> t = new TreeSet<Integer>((a,b)->(a<b)?1:a>b?-1:0);
     t.add(10);
    t.add(0);
     t.add(15);
    t.add(5);
    t.add(20);
    System.out.println("Tree set sorting"+t);


    TreeMap<Integer,String> m = new TreeMap<Integer,String>((I1, I2)->(I1<I2)?1:(I1>I2)?- 1:0);
    m.put(100,"Durga");
    m.put(600,"Sunny");
    m.put(300,"Bunny");
     m.put(200,"Chinny");
     m.put(700,"Vinny");
     m.put(400,"Pinny");
     System.out.println(m);
  }
}
