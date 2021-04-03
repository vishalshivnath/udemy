package generics.samples;

import java.util.List;

public class GenericsWildcards {

  public  Double sum(List<? extends Number> list){
   /* Double double=list.stream().reduce(0, Double::sum);
    return double;*/
   return list.stream().mapToDouble(x->(Double)x).sum();

  }

 /* public  Number sum2(List<? extends Number> list){
   return list.stream().reduce(0, (x,y)->x+y);
  }*/
}
