public class NumberSandGlass {
    public static void main(String[] args) {
        int n = 5;
        for (int i = n; i >= 1; i--) {
            for (int s = n - i; s > 0; s--)
                System.out.print(" ");
            for (int j = 1; j <= i; j++)
                System.out.print(j);
            for (int j = i - 1; j >= 1; j--)
                System.out.print(j);
            System.out.println();
        }
        for (int i = 2; i <= n; i++) {
            for (int s = n - i; s > 0; s--)
                System.out.print(" ");
            for (int j = 1; j <= i; j++)
                System.out.print(j);
            for (int j = i - 1; j >= 1; j--)
                System.out.print(j);
            System.out.println();
        }
    }
}
