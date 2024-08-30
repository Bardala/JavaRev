package OOP.abstraction.abstractClass;

interface InnerAnimal {
  String name = "";

  void walk();

  void sleep();

  void jump();
}

public abstract class Animal implements InnerAnimal {
  String name = "Animal";

  public abstract void run();

  public Animal() {
    System.out.println("Animal object created");
  }

  final void greeting() {
    System.out.println("Hello from Animal class");
  }
}