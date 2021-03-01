package java8features;

@FunctionalInterface
public interface ConvertorInterface<T,V> {
  V convert(T from);
}
