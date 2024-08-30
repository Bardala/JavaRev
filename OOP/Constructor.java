package OOP;

import java.util.ArrayList;

/**
 * *Constructor
 * *Static keyword
 * *This keyword
 */

public class Constructor {
  public int age;
  public String name;
  int[] ages;
  Constructor c;
  float degrees;
  static ArrayList<Constructor> objects = new ArrayList<>();

  public Constructor() {
    this(new int[] { 3, 4 }); // calling constructor

    System.out.println("object created from Constructor");
  }

  public Constructor(int parameter1, String parameter2) {
    this();// calling constructor

    System.out.println(ages);
    // for (int age : ages)
    // System.out.println(age);

    age = parameter1;
    name = parameter2;
    System.out.println("object created from Constructor");
  }

  void print(Constructor obj) {
    System.out.println("method is invoked");
  }

  // *this keyword can be used to return current class instance
  Constructor getInstance() {
    return this;
  }

  void storeThisInstance() {
    objects.add(this);
  }

  ArrayList<Constructor> getStoredObjects() {
    return objects;
  }

  void printCaller() {
    print(this);
  }

  /**
   * *Real usage of this() constructor call
   * The this() constructor call should be used to reuse the constructor from the
   * constructor. It maintains the chain between the constructors i.e. it is used
   * for constructor chaining. Let's see the example given below that displays the
   * actual use of this keyword.
   */
  public Constructor(int parameter1, String parameter2, float parameter3) {
    this(parameter1, parameter2);
    degrees = parameter3;
  }

  public Constructor(int[] arr) {
    ages = arr;
  }

  public Constructor(Constructor c) { // constructor to initialize another obj
    this.c = c;
  }

  public void printInfo() {
    System.out.println(age + " " + name);

    if (this.c != null)
      System.out.println(this.c.age + " " + this.c.name);
  }

  public String toString() {
    return age + " " + name;
  }

  public void printAges() {
    System.out.println("ages: ");

    if (ages != null)
      for (int age : ages) {
        System.out.println(age);
      }
    else
      System.out.println("null");
  }

  public static void main(String[] args) {
    Constructor ins = new Constructor(32, "Islam");

    Constructor cons = new Constructor(45, "Ali");
    cons.printInfo();

    Constructor emptyCons = new Constructor();
    emptyCons.printAges();

    Constructor agesCons = new Constructor(new int[] { 33, 43, 31 });
    agesCons.printAges();

    // *There are many ways to copy the values of one object into another in Java.
    // They are:
    // By constructor
    // By assigning the values of one object into another
    // By clone() method of Object class

    // 1. By Constructor
    Constructor cons2 = new Constructor(cons);
    cons2.printInfo();

    // 2. By assigning the values of one object into another
    Constructor cons3 = new Constructor();
    cons3.age = cons.age;
    cons3.name = cons.name;
    cons3.printInfo();

    System.out.println(ins.toString());
  }
}
