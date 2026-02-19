import java.util.Scanner;

public class SecondSmallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];

        for(int i = 0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int i = 0; i<arr.length; i++) {
            if(arr[i] < first) {
                second = first;
                first = arr[i];
            } else if(arr[i] < second && arr[i] != first) {
                second = arr[i];
            }
        }
        System.out.println(second);
    }
}
