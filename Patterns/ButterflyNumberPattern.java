public class ButterflyNumberPattern {
    public static void main(String[] args) {
        int n = 4;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print(j);
            for (int s = 1; s <= 2 * (n - i); s++)
                System.out.print(" ");
            for (int j = i; j >= 1; j--)
                System.out.print(j);
            System.out.println();
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++)
                System.out.print(j);
            for (int s = 1; s <= 2 * (n - i); s++)
                System.out.print(" ");
            for (int j = i; j >= 1; j--)
                System.out.print(j);
            System.out.println();
        }
    }
}
