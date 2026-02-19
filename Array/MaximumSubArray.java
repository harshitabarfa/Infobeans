import java.util.Scanner;

public class MaximumSubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int currentSum = 0;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            if (currentSum > max) {
                max = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        System.out.println(max);
    }
}
