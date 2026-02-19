import java.util.*;

class Ass3
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter first number: ");
int n1 = sc.nextInt();

System.out.print("Enter second number: ");
int n2 = sc.nextInt();

int a = n1;
int b = n2;

while (b != 0) 
{
int c = b;
b = a % b;
a = c;
}
        
int d = a;

int e = (n1 * n2) / d;

System.out.println("LCM of " + n1 + " and " + n2 + " is: " + e);

}
}
