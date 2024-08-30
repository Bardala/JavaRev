package OOP.inheritance;

public class Programmer extends Employee {
  int bonus = 1000;

  public void run() {
    System.out.println("Salary is " + salary); // inherited variable
    System.out.println("Bonus is " + bonus);
  }

  public static void main(String[] args) {
    Employee employee = new Programmer();
  }
}
