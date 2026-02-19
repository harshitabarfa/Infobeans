import java.util.*;

class Ass6
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
System.out.print("Enter First number: ");
int a = sc.nextInt();

System.out.print("Enter Second number: ");
int b = sc.nextInt();

System.out.println("Sum of " +a+ " and " +b+ " is " + (a+b));

System.out.println("Diffrence between " +a+ " and " +b+ " is " + (a-b));

System.out.println("Product of " +a+ " and " +b+ " is " + (a*b));

System.out.println("Division of " +a+ " and " +b+ " is " + (a/b));

System.out.println("Mod of " +a+ " and " +b+ " is " + (a%b));
}
}