package OOP.polymorphism.covariantReturnType;

class Parent {
  public Parent get() {
    return this;
  }

  public void msg() {
    System.out.println("from parent");
  }

  public void obj() {
    this.msg();
  }
}

public class Sub extends Parent {
  @Override
  public Sub get() {
    return this;
  }

  public void msg() {
    System.out.println("From subClass");
  }

  public static void main(String[] args) {
    Parent sub = new Sub();

    sub.get().msg(); // From subClass
    sub.obj(); // From subClass
  }
}
