package OOP.polymorphism.overriding;

/**
 * *Can we override static method?
 * *No, a static method cannot be overridden. It can be proved by runtime
 * polymorphism, so we will learn it later.
 */

public class Bank {
  int getRateOfInterest() {
    return 0;
  }

  public static void main(String[] args) {
    Bank bank = new CICI();

    System.out.println(bank instanceof CICI); // true
    System.out.println(bank.getClass() == Bank.class); // false
    System.out.println(bank.getClass() == CICI.class); // true

    System.out.println(bank.getRateOfInterest());
  }
}

class SBI extends Bank {
  int getRateOfInterest() {
    return 8;
  }
}

class AXIS extends Bank {
  int getRateOfInterest() {
    return 7;
  }
}

class CICI extends Bank {
  int getRateOfInterest() {
    return 9;
  }
}
