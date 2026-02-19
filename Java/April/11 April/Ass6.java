import java.util.*;

class Ass6
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter the amount: ");
int a = sc.nextInt();

int b = a/10;
int c = (a%10)/5;

System.out.println("10 * " +b+ ", 5 * " +c);
}
}