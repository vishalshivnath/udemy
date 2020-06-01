package generics;

public class Generics02BoundedTypeParamaters {

    private static <T extends Comparable<T>> T compare(T t1,T t2){

        if(t1.compareTo(t2) <0){
            return t1;
        }
        return t2;
    }

    public static void main(String[] args) {

        System.out.println(compare("com","test"));
        System.out.println(compare('A','C'));
        System.out.println(compare(3,4));

    }



}
