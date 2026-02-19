import java.util.*;

public class Binary {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter array size: ");
		int size = sc.nextInt();

		int arr[] = new int[size];

		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println("Enter target: ");
		int tar = sc.nextInt();

		int start = 0;
		int end = size - 1;
		boolean found = false;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (tar > arr[mid]) {
				start = mid + 1;
			} else if (tar < arr[mid]) {
				end = mid - 1;
			} else {
				System.out.println("Element found in index: " +mid);
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("-1 (Element not found)");
		}
	}
}
