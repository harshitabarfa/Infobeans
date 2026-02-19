import java.util.*;
import java.io.*;

public class Ass1 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		try(PrintWriter pr = new PrintWriter("Students.txt"))
		{
			System.out.print("Enter how much student? ");
			int n = sc.nextInt();
			sc.nextLine();
			
			System.out.println("\nEnter student name: ");
			for(int i = 0; i<n; i++)
			{
				String name = sc.nextLine();
				pr.println(name);
			}
			System.out.print("\nSuccess!");
		}
		catch(IOException e)
		{
			System.out.println("Invalid!");
		}
	}
}
