package OOP.inheritance.aggregation;

public class Circle {
  Operation op;
  double pi = 3.14;

  public double area(int radius) {
    op = new Operation();
    int square = op.square(radius);
    return pi * square;
  }
}
