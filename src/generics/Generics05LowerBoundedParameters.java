package generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Generics05LowerBoundedParameters {

    public static void main(String[] args) {
        List<Serializable> list=new ArrayList<>();
        list.add("Adam");
        list.add("Joe");
        list.add("Vis");
        show(list);

    }

    public static void show(List<? super Number> list){

        list.add(new Double(1.1));
        list.add(new Float(2.1));

        for (Object o:list ) {
            System.out.println(o);
        }
    }
}
