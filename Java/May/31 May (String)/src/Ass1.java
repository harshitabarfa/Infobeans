import java.util.*;

public class Ass1 
{
public static void main(String[] args) 
{
	Scanner sc = new Scanner(System.in);
	
	System.out.print("Enter first string: ");
	String s1 = sc.nextLine();
	
	System.out.print("Enter second string: ");
	String s2 = sc.nextLine();
	
	char ch1[] = s1.toCharArray();
	char ch2[] = s2.toCharArray();
	
	int count[] = new int[26];
	
	for(int i=0; i<ch1.length; i++ ) 
	{
		count[s1.charAt(i) - 'a']++;
	}
	
	for(int i=0; i<ch2.length; i++) 
	{
		count[s2.charAt(i) - 'a']--;
	}
	
	for(int i=0; i<count.length; i++) 
	{
		if(count[i] != 0) 
		{
			System.out.println("Not anagram.");
			return;
		}
	}
	System.out.println("Yes, It is a Anagram.");
	
}
}