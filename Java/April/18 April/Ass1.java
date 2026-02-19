import java.util.*;

class Ass1 {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number: ");
    int n1 = sc.nextInt();

    System.out.print("Enter number: ");
    int n2 = sc.nextInt();

    int n;
    int i;

    for (n = n1; n <= n2; n++) {
      int x = 0;
      i = 2;
      while (i < n / 2) {
        if (n % i == 0) {
          x = 1;
          break;
        }
        i++;
      }
      if (x == 0 && n > 1) {
        System.out.print(n + " ");
      }
    }
  }
}