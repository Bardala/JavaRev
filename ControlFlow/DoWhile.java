public class DoWhile {
  static void run() {
    int testVal = 5;
    do {
      System.out.println(testVal);
      testVal++;
    } while (testVal < 10);
  }

  public static void main(String[] args) {
    run();
  }
}
