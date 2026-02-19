import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ContainDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Set<Integer> set = new HashSet<>();
        List<Integer> duplicate = new ArrayList<>();

        for (int x : arr) {
            if (!set.add(x)) {
                duplicate.add(x);
            }
        }

        for (int y : duplicate) {
            System.out.println(y + " ");
        }
    }
}
