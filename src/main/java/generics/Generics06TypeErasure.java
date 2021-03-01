package generics;

public class Generics06TypeErasure {

    public static void main(String[] args) {

    }

}

class  FirstStore<T>{

private T item;

public T getItem(){
return this.item;
}


public void setItem(T item){

    this.item=item;
}


}


