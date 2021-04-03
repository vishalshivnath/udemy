package java8features;

@FunctionalInterface
public interface FunctionalInterfaceA {
  abstract void methodA();
  default void methodB(){
    System.out.println("method b");
  }
}
