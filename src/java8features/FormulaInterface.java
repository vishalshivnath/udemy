package java8features;

public interface FormulaInterface {

  double calculate( int a);

  default double sqrt(int a){return Math.sqrt(a);};

}
