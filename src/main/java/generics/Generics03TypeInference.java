package generics;

import java.util.ArrayList;
import java.util.List;

public class Generics03TypeInference {

    public static <T> void addStore(T t, List<Bucket<T>> listOfBucket){

        Bucket<T> bucket=new Bucket<>();
        bucket.setItem(t);
        listOfBucket.add(bucket);
        System.out.println(t.toString()+ " Bucket has been addeed to list ... ");
    }

    public static void main(String[] args) {

        List<Bucket<String>> listOfBucketString=new ArrayList<>();
        Generics03TypeInference.addStore("Hello Mister",listOfBucketString);
        //
        Generics03TypeInference.<String>addStore("My Passion is coding",listOfBucketString);
    }

}

class Bucket<T> {

    private T item;
    public void setItem(T item){
        this.item=item;
    }

    public T getItem() {
        return this.item;
    }
}
