import java.util.*;
import java.io.*;

public class Ass2
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		File fr = new File("Students.txt");

		if (!fr.exists()) 
		{
            System.out.println("File does not exist!");
            return;
        }
		try(BufferedReader br = new BufferedReader(new FileReader(fr)))
		{
			String line;
			while((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
		}
		catch(IOException e)
		{
			System.out.println("Invalid!");
		}
	}
}
