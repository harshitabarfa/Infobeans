import java.util.Arrays;
import java.util.Scanner;

public class MergeSorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();

        int arr1[] = new int[n1];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }
        int m1 = sc.nextInt();

        int n2 = sc.nextInt();
        int arr2[] = new int[n2];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = sc.nextInt();
        }
        int m2 = sc.nextInt();

        for (int i = 0; i < m2; i++) {
            arr1[m1 + i] = arr2[i];
        }

        Arrays.sort(arr1);
        System.out.print(Arrays.toString(arr1));
    }
}
