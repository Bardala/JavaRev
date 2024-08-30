public class BreakStatement {

  void main() {
    for (int i = 0; i <= 2; i++) {
      for (int j = i; j <= 5; j++) {
        if (j == 4) {
          continue;
        }
        System.out.println(j);
      }
    }
  };

}
