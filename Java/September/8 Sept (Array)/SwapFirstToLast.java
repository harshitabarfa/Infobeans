import java.util.*;

public class SwapFirstToLast {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size: ");
        int size = sc.nextInt();

        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int temp = arr[0];
        arr[0] = arr[size - 1];
        arr[size - 1] = temp;

        for (int i = 0; i < size; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}
