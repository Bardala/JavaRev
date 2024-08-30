import OOP.Constructor;
import OOP.Student;
import OOP.abstraction.abstractClass.Animal;
import OOP.abstraction.abstractClass.Lion;
import OOP.abstraction.javaInterface.MainInterface;
import OOP.inheritance.Programmer;
import OOP.inheritance.aggregation.Circle;
import OOP.polymorphism.covariantReturnType.Sub;
import OOP.polymorphism.overloading.Adder;
import OOP.polymorphism.superKeyword.Dog;

public class Main {
  // You can have any number of main methods in a class by method overloading. But
  // JVM calls main() method which receives string array as arguments only.
  /** Overloading Main method */
  public static void main(String args) {
    System.out.println("main with String");
  }

  /** Overloading Main method */
  public static void main() {
    System.out.println("main without args");
  }

  /**
   * *Java static block
   * Is used to initialize the static data member.
   ** It is executed before the main method at the time of classloading.
   */
  static {
    System.out.println("static block is invoked");
  }

  int num;

  void printHello() {
    System.out.println("Hello");
  }

  static int sum(int operand1, int operand2) {
    // System.out.println(num);
    // System.out.println(printHello);
    return operand1 + operand2;
  }

  static int staticVariable = 100; // *static variable

  void method() {
    int localVariable = 90;// local variable
    System.out.println("Static variable from a method " + staticVariable);
    System.out.println(localVariable);
  }

  public static void main(String args[]) {
    System.out.println("Hello this is the main method");

    System.out.println(0b1101001); // base 2
    System.out.println(016); // base 8 starts with zero
    System.out.println(123); // base 10
    System.out.println(0xA); // base 16 starts with 0x

    int instanceVariable = 50; // *instance variable
    System.out.println(instanceVariable);

    System.out.println("Static variable from the main method " + staticVariable);

    Main ins = new Main();
    ins.method();

    float floatVar = (float) staticVariable;
    System.out.println(floatVar);

    floatVar = 10.2f; // *Float variable should end with letter 'f' with dot notation.
    System.out.println(floatVar);

    float increasingVar = 0;

    System.out.println(increasingVar++);

    System.out.println(++increasingVar);

    /**
     * byte: has 1 byte = 8 bits
     * range: -2^7 -> 2^7 - 1 (-128 -> 127)
     */

    /**
     * short: has 2 bytes = 16 bits
     * range: -2^15 -> 2^15 - 1 (-32,768 -> 32,767)
     */

    /**
     * int: has 4 bytes = 32 bits
     * range: -2^31 -> 2^31 - 1 (-2,147,483,648 -> 2,147,483,647)
     */

    /**
     * long: has 8 bytes = 64 bits
     * range: -2^63 -> 2^63 - 1 (-9,223,372,036,854,775,808 ->
     * 9,223,372,036,854,775,807)
     */

    /**
     * float: has 4 bytes = 32 bits
     * range: Approximately ±1.4E-45 -> ±3.4E+38
     */

    /**
     * double: has 8 bytes = 64 bits
     * range: Approximately ±4.9E-324 -> ±1.7E+308
     */

    /**
     * char: has 2 bytes = 16 bits
     * range: 0 -> 2^16 - 1 (0 -> 65,535)
     */

    /**
     * boolean: has 1 bit (typically 1 byte is used for alignment)
     * range: true or false
     */

    short a = 10, b = 10;
    a += b;
    System.out.println(a);

    a = (short) (a + b);
    System.out.println(a);

    int trySwitch = 10;

    switch (trySwitch) {
      case 0:
        System.out.println("trySwitch = 0");
        break;
      case 10:
        System.out.println("trySwitch = 10");
        break;
      default:
        System.out.println("trySwitch doesn't equal zero or 10");
        break;
    }

    ForLoop forLoop = new ForLoop();

    new DoWhile().run();
    forLoop.forEach();
    forLoop.simpleFor();
    forLoop.printStars();
    forLoop.labeledForLoop();

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

    System.err.println();

    /*
     * *Static keyword
     * Java static property is shared to all objects.
     * 
     * The static variable can be used to refer to the common property of all
     * objects, which is not unique for each object.
     * 
     * The static variable gets memory only once in the class area at the time of
     * class loading.
     * 
     * static variable will get the memory only once, if any object changes the
     * value of the static variable, it will retain its value.
     */
    Student ali = new Student(2, "Ali");
    ali.printInfo();
    ali.printNumberOfStudents(); // 1

    Student islam = new Student(3, "Islam");
    islam.printInfo();
    islam.printNumberOfStudents(); // 2

    Student taha = new Student(4, "Taha");
    taha.printNumberOfStudents(); // 3

    // *All the objects share the static variable, so they can change it with each
    // other.

    /*
     * *
     * Static Method:
     * A static method belongs to the class rather than the object of a class.
     * 
     * A static method can be invoked without the need for creating an instance of a
     * class.
     * 
     * A static method can access static data member and can change the value of it.
     * 
     * //? The static method can not use non static data member or call non-static
     * //? method directly.
     * 
     * //? this and super cannot be used in static context.
     */
    islam.getTimesOfPrintingInfoCalls(); // 2

    int sum = Main.sum(3, 4); // You don't need to create an instance to use static method.
    System.out.println(sum);

    // *Q) Why is the Java main method static?
    // Ans) It is because the object is not required to call a static method. If it
    // were a non-static method, JVM creates an object first then call main() method
    // that will lead the problem of extra memory allocation.

    System.out.println();

    /**
     * * Inheritance
     */
    Programmer employee = new Programmer();
    employee.run();

    /**
     * *Inheritance
     * Aggregation: a type of relationship between classes that represents a "has-a"
     * relationship
     */
    Circle circle = new Circle();
    double area = circle.area(5);
    System.out.println("The area of circle = " + area);

    /**
     * *Overloading
     */
    System.out.println(Adder.add(5, 4));
    System.out.println(Adder.add(1, 2, 3));
    System.out.println(Adder.add(.4, 54.4, 10.01));

    /**
     * Convariant Return Type
     */
    Sub sub = new Sub();
    sub.get().msg();

    /**
     * *Super keyword
     */
    Dog dog = new Dog();
    dog.run();

    System.out.println();

    /**
     * * Final keyword
     * * 1. Stop value change.
     * * 2. Stop method overriding.
     * * 3. Stop class inheritance.
     * * It can be static.
     * * You set instance variable as final, and initialize it only through the
     * constructor.
     */

    /**
     * * Abstraction
     */
    Animal lion = new Lion(); // upcasting
    lion.run();
    lion.sleep();

    System.out.println();

    /**
     * * Interface
     */
    MainInterface obj = new MainInterface();
    obj.print();
    obj.greeting(); // default method from the interface
    obj.show();
    System.out.println(obj.sum(5, 8));

    /**
     * Package
     */
    System.out.println("Compile Package");
  }
}
