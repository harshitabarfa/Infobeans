public class Ass1 
{
	public static void main(String args[])
	{
		try
		{
			String i = args[0];
			String j = args[1];
			
			int x = Integer.parseInt(i);
			int y = Integer.parseInt(j);
			
			int z = x/y;
			
			System.out.println(z);
		}
		catch(ArrayIndexOutOfBoundsException a)
		{
			System.out.println("Values are not given in command line arguments");
		}
		catch(NumberFormatException n)
		{
			System.out.println("Please enter integer values");
		}
		catch(ArithmeticException e)
		{
			System.out.println("please do not enter zero");
		}
		finally
		{
			System.out.println("All task done");
		}
	}
	
}
