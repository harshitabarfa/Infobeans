import java.util.*;

class Ass6
{
public static void main(String args[]) 
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter first number: ");
int n1 = sc.nextInt();

System.out.print("Enter second number: ");
int n2 = sc.nextInt();

for (int n = n1; n <= n2; n++) 
{
int fact = 1;

for (int i = 1; i <= n; i++) 
{
fact *= i;
}

System.out.println("Factorial of " + n + " is: " + fact);
}

}
}
