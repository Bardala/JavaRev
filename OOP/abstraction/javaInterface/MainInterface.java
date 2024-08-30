package OOP.abstraction.javaInterface;

/**
 * *Why use Java interface?
 * There are mainly three reasons to use interface. They are given below.
 * 
 * It is used to achieve abstraction.
 * By interface, we can support //*the functionality of multiple inheritance.
 * It can be used to achieve loose coupling.
 */

/**
 * The Java compiler adds public and abstract keywords before the interface
 * method. Moreover, it adds public, static and final keywords before data
 * members.
 */

/**
 * *Q) Multiple inheritance is not supported through class in java, but it is
 * possible by an interface, why?
 * 
 * multiple inheritance is not supported in the case of class because of
 * ambiguity. However, it is supported
 * in case of an interface because there is no ambiguity.
 * * It is because its implementation is provided by the implementation class.
 */

interface ParentInterface {
  void show(); // javac -> public abstract void show()

  int interfaceVariable = 2; // javac -> public static final int interfaceVariable = 1

  // *Interface can have static methods
  static int sum(int operand1, int operand2) {
    return operand1 + operand2;
  }

}

interface InnerMainInterface_1 extends ParentInterface {
  double min();
  // default void greeting() {
  // System.out.println("Hello from interface InnerMainInterface");
  // }
  // we can't duplicate default methods to be inherited from a class.
  // error: Duplicate default methods named greeting with the parameters () and ()
  // are inherited from the types InnerMainInterface_1 and InnerMainInterface
}

interface InnerMainInterface {
  int min = 5; // -> public static final int min = 5;

  void print(); // -> public abstract void print();

  default void greeting() {
    System.out.println("Hello from interface InnerMainInterface");
  }

  void show();
}

// *Nested Interface in Java
// Note: An interface can have another interface which is known as a nested
// interface
interface printable {
  void print();

  interface MessagePrintable {
    void msg();
  }
}

public class MainInterface implements InnerMainInterface, InnerMainInterface_1 {
  @Override
  public void print() {
    System.out.println("Hello from MainInterface");
  }

  @Override
  public double min() {
    return 10.4d;
  }

  @Override
  public void show() {
    System.out.println(
        "this method is inherited from two interfaces, but there is not ambiguity, as the implementation happens in the class");
  }

  public int sum(int operand1, int operand2) {
    return ParentInterface.sum(operand1, operand2);
  }

  public static void main(String[] args) {
    MainInterface obj = new MainInterface();
    obj.print();
    obj.greeting(); // default method from the interface
    obj.show();
    System.out.println(obj.sum(5, 8));
  }

}
