import java.util.Scanner;

public class Ass5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter String: ");
		String s = sc.nextLine();
		
		char c[] = new char[s.length()];
		
		int len = 0;
		
		for(int i = 0; i<s.length(); i++)
		{
			char ch = s.charAt(i);
			if (ch == ' ') {
                c[len] = ch;
                len++;
            }
		}
		System.out.print(len);
	}
}
