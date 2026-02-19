import java.util.Scanner;

public class OddSubArray {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;

        for(int i = 0; i<arr.length; i++) {
            for(int j = i; j<arr.length; j++) {
                if((j-i+1)%2==1) {
                    for(int k = i; k<=j; k++) {
                        sum += arr[k];
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
