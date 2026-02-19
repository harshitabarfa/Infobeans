import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Intersection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a[] = {1,2,2,1};
        int b[] = {2,2};

        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();

        while(i<a.length && j<b.length) {
            if(a[i] == b[j]) {
                list.add(a[i]);
                i++;
                j++;
            } else if(a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }

        int result[] = new int[list.size()];
        for(int k = 0; k<list.size(); k++) {
            result[k] = list.get(k);
        }
        System.out.println(Arrays.toString(result));
    }
}