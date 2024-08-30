package OOP;

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

/*
 * *
 * Static Method:
 * A static method belongs to the class rather than the object of a class.
 * 
 * A static method can be invoked without the need for creating an instance of a
 * class.
 * 
 * A static method can access static data member and can change the value of it.
 */

public class Student {
  int id; // instance variable
  String name;
  static String collegeName = "MIT"; // *static variable */
  static int studentNumber = 0;
  static int printInfoTimes = 0;

  public Student(int id, String name) {
    this.id = id;
    this.name = name;

    studentNumber++;
  }

  static void cantAccessInstanceVariablesOrMethods() {
    // System.out.println(id); // Compiler time error
    // this.printInfo() // Cannot use this in a static context

    new Student(4, "test").printNumberOfStudents();
  }

  public void printInfo() {
    System.out.println("Student " + this.name + " has id " + this.id + " and study in " + collegeName);

    printInfoTimes++; // *changing static variable from instance method.
  }

  public void printNumberOfStudents() {
    System.out.println("Number of students = " + studentNumber);
  }

  public void getTimesOfPrintingInfoCalls() {
    System.out.println(printInfoTimes);
  }
}
