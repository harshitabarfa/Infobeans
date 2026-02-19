import java.util.Scanner;

public class BuySell {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int i = 0; i<arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            } else if(arr[i] - min > max) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }
}
