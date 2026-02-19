public class NumberXPattern {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    System.out.print(i);
                else if (i + j == n + 1)
                    System.out.print(n - i + 1);
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
