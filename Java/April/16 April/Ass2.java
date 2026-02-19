import java.util.*;

class Ass2
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter a number: ");
int n = sc.nextInt();

int fact = 1;
int i = 1;

// While loop:
// while(i<=n)
// {
// fact *= i;
// i++;
// }
// System.out.println(fact);

// For loop:
for(i = 1; i<=n; i++)
{
fact *=i;
}
System.out.println(fact);


// Do-while loop:
// do{
// fact = fact*i;
// i++;
// }
// while(i<=n);
// System.out.println(fact);
}
}
