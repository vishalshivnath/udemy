package generics.samples;

public class TestForBounding <T extends Comparable<T>> {

  private T data;
  private TestForBounding<T> next;

  public TestForBounding(T d, TestForBounding<T> n) {
    this.data = d;
    this.next = n;
  }

  public T getData() { return this.data; }
}
