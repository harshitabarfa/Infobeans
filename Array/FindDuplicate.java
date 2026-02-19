import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FindDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Set<Integer> set = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for(int x : arr) {
            if(!set.add(x)) {
                duplicates.add(x);
            }
        }

        for(int x : duplicates) {
            System.out.print(x + " ");
        }
    }
}
