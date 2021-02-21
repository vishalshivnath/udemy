package java8features;

public class FormulaImpl {

  public static void main(String[] args) {
    FormulaInterface formula=new FormulaInterface() {
      @Override
      public double calculate(final int a) {
        return 0;
      }
    };

    System.out.println(formula.sqrt(2)+"-->"+formula.calculate(1));


  }
}
