import java.util.*;

class Ass4 {
public static void main(String[] args) 
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter first number: ");
int n1 = sc.nextInt();

System.out.print("Enter second number: ");
int n2 = sc.nextInt();

int a = (n1 < n2) ? n1 : n2;

int b = 1;
for (int i = 1; i <= a; i++) {

if (n1 % i == 0 && n2 % i == 0) 
{
b = i;
}
}

System.out.println("HCF of " + n1 + " and " + n2 + " is: " + b);

}
}
