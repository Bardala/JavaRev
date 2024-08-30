package OOP.polymorphism.superKeyword;

class Animal {
  String color = "white";

  Animal() {
    System.out.println("Animal is created");
  }

  void animalGreeting() {
    System.out.println("The Animal says 'Hello'");
  }

  public void run() {
  }
}

public class Dog extends Animal {
  String color = "yellow";

  public Dog() {
    super(); // this will print the implementation of the superclass
    System.out.println("Dog is created");
  }

  public void printDogColor() {
    super.animalGreeting();
    System.out.println("Dog color: " + color);
  }

  public void run() {
    printDogColor();
    System.out.println("Animal color: " + super.color);
  }

  public static void main(String[] args) {
    Animal dog = new Dog();

    dog.run();
  }
}
