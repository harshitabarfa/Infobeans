import java.util.*;

class Ass7
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
System.out.print("Enter a: ");
int a = sc.nextInt();

System.out.print("Enter b: ");
int b = sc.nextInt();

System.out.print("Enter c: ");
int c = sc.nextInt();

int d = (a >= b && a >= c) ? a : (b >= a && b >= c) ? b : c;
System.out.println("The largest number is :" +d);
}
}

