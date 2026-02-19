public class ReverseNumberTriangle {
    public static void main(String[] args) {

        int n = 5;

        for (int i = 1; i <= n; i++) {
            int count = i - 1;
            int num = 2 * count;

            for (int j = 1; j <= count; j++) {
                System.out.print(num + " ");
                num--;
            }
            for (int d = 1; d <= n - i; d++) {
                System.out.print("- ");
            }
            System.out.println();
        }
    }
}

