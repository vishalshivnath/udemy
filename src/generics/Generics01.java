package generics;

class Store<T> {

    private  T item;

    public void setStoreItem(T item){
        this.item=item;
    }

    public T getItem(){
        return this.item;
    }

    @Override
    public String toString(){
        return  ""+this.item.toString();
    }

}

class HashTable<K,V>{
    K key;
    V value;
    public HashTable(K key,V value){
        this.key=key;
        this.value=value;
    }

    @Override
    public String toString(){
        return  "key-->"+this.key.toString()+ ": value-->"+this.value.toString();
    }
}

class GenericMethods{

    public <T> void showItem(T type){
        System.out.println("This item is ->"+type.toString());
    }

    public <T> void showArray(T[] arrays){

        for(T item: arrays){
            System.out.println(item.toString());
        }
    }

    public <T> T getItem(T type){
        return  type;

    }
}

public class Generics01 {

    public static void main(String[] args) {
        Store<String> stringStore=new Store<>();
        stringStore.setStoreItem("Hello");
        String stringStore1=stringStore.getItem();
        System.out.println(stringStore1);


        Store<Integer> intStore=new Store<>();
        intStore.setStoreItem(1);
        Integer intStore1=intStore.getItem();
        System.out.println(intStore);

        HashTable<String,Integer> hashTable=new HashTable<>("Cent",50);
        System.out.println(hashTable);

        GenericMethods genericMethods=new GenericMethods();
        genericMethods.showItem("A String");
        genericMethods.showItem(1);

        Integer[] integersArray={1,4,5,3,43};
        String[] stringArray={"One","Two","Three"};
        genericMethods.showArray(integersArray);
        genericMethods.showArray(stringArray);

    }
}
