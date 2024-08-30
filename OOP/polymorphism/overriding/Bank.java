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