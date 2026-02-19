import java.util.Scanner;

public class Ass2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter String: ");
		String s = sc.nextLine();
		
		int vowel = 0;
		int consonant = 0;
		
		for(int i = 0; i<s.length(); i++)
		{
			char ch = s.charAt(i);
			
			if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
			{
				vowel++;
			}
			else
			{
				consonant++;
			}
		}
		
		System.out.println("Vowels: " + vowel);
		System.out.println("Consonant: " + consonant);
	}
}
