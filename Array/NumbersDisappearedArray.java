import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class NumbersDisappearedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Set<Integer> set = new HashSet<>();
        for(int x : arr) {
            set.add(x);
        }

        List<Integer> list = new ArrayList<>();

        for(int i = 1; i<=arr.length; i++) {
            if(!set.contains(i)) {
                list.add(i);
            }
        }

        for(int y : list) {
            System.out.print(y + " ");
        }
    }
}
