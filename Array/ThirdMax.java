import java.util.Scanner;
import java.util.TreeSet;

public class ThirdMax {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        TreeSet<Integer> set = new TreeSet<>();

        for(int x : arr) {
            set.add(x);
            if(set.size() > 3) {
                set.pollFirst();
            }
        }

        if(set.size() < 3) {
            System.out.print(set.last());
        } else {
            System.out.print(set.first());
        }
    }
}
