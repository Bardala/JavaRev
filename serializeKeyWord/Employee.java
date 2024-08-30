package serializeKeyWord;

import java.io.*;

/*
 * What is the transient keyword?The transient keyword is used at the time of
 * serialization if we don’t want to save the value of a particular variable in
 * a file.When JVM comes across a transient keyword,it ignores the original
 * value of the variable and saves the default value of that variable data type.
 */
class Employee implements Serializable {
  private static final long serialVersionUID = 1L;
  private String name;
  private transient String password; // This field will not be serialized
  static transient String pass;
  static String fileName = "testTransient";

  public Employee(String name, String password) {
    this.name = name;
    this.password = password;
  }

  public static void writePasswordToFile() {
    try {
      Employee emp = new Employee("islam", "This should not be read");

      Writer r = new FileWriter(fileName);
      r.write(emp.password);
      r.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  static void readPasswordFromFile() {
    try {
      Reader r = new FileReader(fileName);
      int i;

      while ((i = r.read()) != -1)
        System.out.print((char) i);

      r.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  @Override
  public String toString() {
    return "Employee{name='" + name + "', password='" + password + "'}";
  }

  public static void main(String[] args) {
    Employee emp = new Employee("John Doe", "secret123");

    // Serialize the object
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.ser"))) {
      oos.writeObject(emp);
    } catch (IOException e) {
      e.printStackTrace();
    }

    // Deserialize the object
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.ser"))) {
      Employee deserializedEmp = (Employee) ois.readObject();
      System.out.println("Deserialized Employee: " + deserializedEmp);
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }

    pass = "asdfadsf";
    System.out.println(pass);

    // tr
    writePasswordToFile();
    readPasswordFromFile();
  }
}
