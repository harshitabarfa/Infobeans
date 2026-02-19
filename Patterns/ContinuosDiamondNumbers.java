public class ContinuosDiamondNumbers {
    public static void main(String[] args) {
        int n = 4, num = 1;
        for (int i = 1; i <= n; i++) {
            for (int s = n - i; s > 0; s--)
                System.out.print(" ");
            for (int j = 1; j <= i; j++)
                System.out.print(num++ + " ");
            System.out.println();
        }
        num = 4;
        for (int i = n - 1; i >= 1; i--) {
            for (int s = n - i; s > 0; s--)
                System.out.print(" ");
            for (int j = 1; j <= i; j++)
                System.out.print(num++ + " ");
            System.out.println();
        }

    }
}
