import java.util.*;

class Ass5 
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter total cart: ");
int a = sc.nextInt();

int b = (a*12/100);
System.out.println("Tax amount (12%): "+b);

int c = a+b;
System.out.println("Total: "+c);
}
}