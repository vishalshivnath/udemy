package java8features;

public class ConstructorReferenceUsingDoubleColon {

  public static void main(String[] args) {
    Interface interface1=MathOperations::new;
    interface1.operators(10);

    Interface interface2=s->new MathOperations(s);
    interface2.operators(20);

  }
}

class MathOperations{
  int anInt;
  MathOperations(int anInt){
    this.anInt=anInt;
    System.out.println("Constructor reference"+anInt);
  }
}

interface Interface{
  public MathOperations operators(int anInt);
}