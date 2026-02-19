public class NumberTraingleDashes {
	public static void main(String[] args) {

		int n = 5;

		for (int i = 1; i <= n; i++) {
			for (int d = 1; d <= n - i; d++) {
				System.out.print("- ");
			}
			int num = i;
			for (int j = 1; j <= i; j++) {
				System.out.print(num + " ");
				num++;
			}
			System.out.println();
		}
	}
}
