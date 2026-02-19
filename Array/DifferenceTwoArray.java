import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DifferenceTwoArray {
    public static void main(String[] args) {
        int a[] = { 1, 2, 3 };
        int b[] = { 2, 4, 6 };

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int x : a)
            set1.add(x);
        for (int y : b)
            set2.add(y);

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for(int i : set1) {
            if(!set2.contains(i)) {
                list1.add(i);
            }
        }

        for(int j : set2) {
            if(!set1.contains(j)) {
                list2.add(j);
            }
        }

        System.out.println(Arrays.asList(list1, list2));
    }
}
