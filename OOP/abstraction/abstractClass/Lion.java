package OOP.abstraction.abstractClass;

public class Lion extends Animal {
  final String name;

  static {
    System.out.println("From static block"); // 1th output
  }
  // 2nd output from the parent class
  {
    name = "Lion"; // this line executed before the constructor (before creating a new instance)
    System.out.println("From block"); // 3rd output
  }

  public Lion() {
    super();
    System.out.println(name + " is created"); // 4th output
  }

  @Override
  public void run() {
    System.out.println(name + " is running");
  }

  @Override
  public void walk() {
    System.out.println(name + " is walking");
  }

  @Override
  public void sleep() {
    System.out.println(name + " is sleeping");
  }

  @Override
  public void jump() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'jump'");
  }

  public static void main(String[] args) {
    Lion lion = new Lion();
  }
}
