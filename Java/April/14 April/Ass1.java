import java.util.*;

class Ass1
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
System.out.print("Enter first number: ");
int a = sc.nextInt();
System.out.print("Enter second number: ");
int b = sc.nextInt();

if(a>b)
System.out.println("A is greater");
else if(b>a)
System.out.println("B is greater");
else
System.out.println("Number is equal");
}
}
