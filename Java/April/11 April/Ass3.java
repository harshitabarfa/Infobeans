import java.util.*;

class Ass3
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter total bill amount: ");
int a = sc.nextInt();

System.out.print("Enter number of friends: ");
int b = sc.nextInt();

float c = a/b;
System.out.println("How much each one should pay: "+c);

}
}