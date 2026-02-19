import java.util.Scanner;

public class Ass3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter String: ");
		String s = sc.nextLine();
		
		char c[] = new char[s.length()];
		
		int len = 0;
		
		for(int i = 0; i<s.length(); i++)
		{
			char ch = s.charAt(i);
			if (ch != ' ') {
                c[len] = ch;
                len++;
            }
		}
		
		char r[] = new char[len];
		
        for (int i = 0; i < len; i++) {
            r[i] = c[len - 1 - i];
        }

        System.out.print("Reversed String: ");
        for (int i = 0; i < len; i++) {
            System.out.print(r[i]);
        }
	}
}
