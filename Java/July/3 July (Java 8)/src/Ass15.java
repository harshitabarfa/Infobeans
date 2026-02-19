import java.util.Scanner;

interface WordCounter
{
	public int countWords(String sentence);
}

public class Ass15 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String s = sc.nextLine().toLowerCase();
		
		
		WordCounter v = sentence -> {
			int count = 0;
			for(int i= 0; i<s.length(); i++)
			{
				char ch = s.charAt(i);
				if(ch != ' ')
				{
					count++;
				}
			}
			return count;
		};
		System.out.println(v.countWords(s));
	}
}
