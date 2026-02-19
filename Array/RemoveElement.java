import java.util.Scanner;

public class RemoveElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int val = sc.nextInt();
        int k = 0;

        for(int i = 0; i<arr.length; i++) {
            if(arr[i] != val) {
                arr[k] = arr[i];
                k++;
            }
        }

        for(int i = 0; i<k; i++) {
            System.out.println(arr[i]);
        }
    }
}
