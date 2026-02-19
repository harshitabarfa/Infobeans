import java.util.Scanner;

public record SecondLargest() {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];

        for(int i = 0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int i = 0; i<arr.length; i++) {
            if(arr[i] > first) {
                first = arr[i];
                arr[i] = second;
            } else if(arr[i] > second && arr[i] != first) {
                second = arr[i];
            }
        }
        System.out.println(second);
    }
}
