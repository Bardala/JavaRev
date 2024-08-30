# Access Modifiers in Java

Access modifiers in Java are keywords used to define the scope and visibility of classes, methods, and variables. They are essential for encapsulation, a core principle of object-oriented programming. Java has four main access modifiers:

## Private

- **Scope**: Accessible only within the same class.
- **Usage**: Used to restrict access to methods and variables, ensuring they cannot be accessed or modified from outside the class.
- **Example**:
  ```java
  class Example {
      private int data = 40;
      private void display() {
          System.out.println("Data: " + data);
      }
  }
  ```

## Default (Package-Private)

- **Scope**: Accessible only within the same package. If no access modifier is specified, it defaults to this level.
- **Usage**: Useful for grouping related classes that should interact with each other but not with classes outside the package.
- **Example**:
  ```java
  class Example {
      void display() {
          System.out.println("Default Access");
      }
  }
  ```

## Protected

- **Scope**: Accessible within the same package and by subclasses in different packages.
- **Usage**: Allows a class to expose its members to its subclasses while keeping them hidden from other classes.
- **Example**:

  ```java
  package p1;
  public class A {
      protected void display() {
          System.out.println("Protected Access");
      }
  }

  package p2;
  import p1.A;
  public class B extends A {
      public static void main(String[] args) {
          B obj = new B();
          obj.display();
      }
  }
  ```

## Public

- **Scope**: Accessible from any other class.
- **Usage**: Used for classes, methods, and variables that need to be accessible from any other part of the program.
- **Example**:
  ```java
  public class Example {
      public void display() {
          System.out.println("Public Access");
      }
  }
  ```

## Summary Table

| Access Modifier | Within Class | Within Package | Outside Package by Subclass | Outside Package |
| --------------- | ------------ | -------------- | --------------------------- | --------------- |
| Private         | Yes          | No             | No                          | No              |
| Default         | Yes          | Yes            | No                          | No              |
| Protected       | Yes          | Yes            | Yes                         | No              |
| Public          | Yes          | Yes            | Yes                         | Yes             |

These access modifiers help control the visibility and accessibility of your code, promoting better encapsulation and modularity.

# Method Overriding Access Modifiers in Java

In Java, when overriding methods, the access level of the overridden method in the subclass must be the same or less restrictive than the method in the superclass. This ensures that the overridden method is accessible in the same contexts as the original method. Below is a table summarizing the rules for overriding methods with different access modifiers.

| Superclass Method Access Modifier | Subclass Method Access Modifier | Allowed? |
| --------------------------------- | ------------------------------- | -------- |
| Default                           | Protected                       | Yes      |
| Default                           | Public                          | Yes      |
| Default                           | Private                         | No       |
| Protected                         | Public                          | Yes      |
| Protected                         | Default                         | No       |
| Protected                         | Private                         | No       |

### Summary

- You can override a method with a **default** access modifier in the superclass to **protected** or **public** in the subclass.
- You can override a method with a **protected** access modifier in the superclass to **public** in the subclass.
- You **cannot** override a method with a **default** access modifier in the superclass to **private** in the subclass.
- You **cannot** override a method with a **protected** access modifier in the superclass to **default** or **private** in the subclass.

These rules help maintain the integrity and accessibility of methods in object-oriented programming.
