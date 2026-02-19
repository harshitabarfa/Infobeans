public class SpiralNumberSquare {
    public static void main(String[] args) {
        int n = 4, val = 1;
        int[][] a = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;

        while (val <= n * n) {
            for (int i = left; i <= right; i++)
                a[top][i] = val++;
            top++;
            for (int i = top; i <= bottom; i++)
                a[i][right] = val++;
            right--;
            for (int i = right; i >= left; i--)
                a[bottom][i] = val++;
            bottom--;
            for (int i = bottom; i >= top; i--)
                a[i][left] = val++;
            left++;
        }
        for (int[] r : a) {
            for (int x : r)
                System.out.print(x + " ");
            System.out.println();
        }
    }
}
