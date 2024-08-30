public class ForLoop {

  void forEach() {
    String[] names = { "ahmed", "Ali", "Islam" };
    for (String name : names) {
      System.out.println(name);
    }
  }

  void simpleFor() {
    int num = 1;

    for (int i = num; i <= 3; i++) {
      for (int j = 1; j <= 3; j++) {
        System.out.println(i + " " + j);
      }
    }
  }

  void printStars() {
    int starRows = 5;

    for (int i = starRows; i > 0; i--) {
      for (int j = i; j > 0; j--) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  void labeledForLoop() {
    int num = 3;

    outer: for (int i = num; i > 0; i--) {
      inner: for (int j = i; j > 0; j--) {
        if (i == 2 && j == 2) {
          break outer;
        }

        System.out.println(i + " " + j);
      }
    }
  }

  public static void main(String args[]) {
    ForLoop ins = new ForLoop();
    ins.printStars();
    System.out.println();

    ins.labeledForLoop();
  }
}
