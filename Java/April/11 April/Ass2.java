import java.util.*;

class Ass2
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter your age in years: ");
int a = sc.nextInt();

int b = a*365;
int c = b*24;
int d = c*60;

System.out.println("Days: "+b);
System.out.println("Hours: "+c);
System.out.println("Minutes: "+d);
}
}