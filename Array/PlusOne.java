import java.util.Arrays;
import java.util.Scanner;

public class PlusOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = arr.length-1; i>0; i--) {
            if(arr[i] < 9) {
                arr[i] += 1;
                System.out.println(Arrays.toString(arr));
                return;
            }
            arr[i] = 0;
        }

        int result[] = new int[arr.length+1];
        result[0] = 1;
        System.out.println(Arrays.toString(result));
    }
}
