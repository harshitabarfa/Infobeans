import java.util.*;
import java.io.*;

public class Ass1 
{
	public static void main(String args[])
	{
		List<Integer> l = new ArrayList<>();
		
		try (PrintWriter pr = new PrintWriter("Number.txt"))
		{
			pr.println(23);
		    pr.println(13);
		    pr.println(43);
		    pr.println(33);
		    pr.println(53);
		    pr.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error!");
			return;
		}
		
		try (BufferedReader br = new BufferedReader(new FileReader("Number.txt")))
		{
			String i;
			while((i = br.readLine()) != null)
			{
				l.add(Integer.parseInt(i));
			}
		}
		catch(IOException e)
		{
			System.out.println("Error!");
		}
		
		Collections.sort(l);
		System.out.println(l);
		
		try (PrintWriter p = new PrintWriter("sorted_numbers.txt")) 
		{
		    for (Integer num : l) 
		    {
		        p.println(num);
		    }
		} 
		catch (FileNotFoundException e) 
		{
		    System.out.println("Error!");
		}

	}
}
