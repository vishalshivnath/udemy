package java8features;


interface  inter1{
  public void m1(int int1);
}

public class MethodReferenceUsingDoubleColon {

  public void m2(int int2){
    System.out.println("from instance method reference"+int2);
  }

  public static void main(String[] args) {
    inter1 inter1=i-> System.out.println("lambda function"+i);
    inter1.m1(10);
    MethodReferenceUsingDoubleColon methodReference=new MethodReferenceUsingDoubleColon();
    inter1 inter11=methodReference::m2;
    inter11.m1(20);
    inter1 inter12=MethodReferenceUsingStaticMethod::m3;
    inter12.m1(30);
  }
}

class MethodReferenceUsingStaticMethod{
  public static void m3(int int3){
    System.out.println("from static method reference"+int3);
  }
}
