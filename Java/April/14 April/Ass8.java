import java.util.*;

class Ass8
{
public static void main(String args[])
{

Scanner sc = new Scanner(System.in);

System.out.print("Enter age: ");
int a = sc.nextInt();

if(a >= 0 && a<=12)
System.out.println("Ticket price for children is 100");
else if(a >= 13 && a<=59)
System.out.println("Ticket price for Adults is 150");
else if(a >= 60)
System.out.println("Ticket price for senior citizens is 120");
else
System.out.println("Invalid age!");
}
}
