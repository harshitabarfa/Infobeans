import java.util.*;

class Ass9
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
System.out.print("Enter number: ");
int num = sc.nextInt();

int n = num;
int count = 0;
int a = 0;
// while(n > 0)
// {
// int digit = n % 10;
// a++;
// if (digit % 2 == 0)
// {
// count++;
// }
// n /= 10;
// }
// if(count == a )
// System.out.println("All Even");
// else
// System.out.println("Not All Even");


// do
// {
// int digit = n % 10;
// a++;
// if (digit % 2 == 0)
// {
// count++;
// }
// n /= 10;
// }
// while(n>0);
// if(count == a)
// System.out.println("All Even");
// else
// System.out.println("Not All Even");


for(; n>0; n=n/10)
{
int digit = n % 10;
a++;
if (digit % 2 == 0)
{
count++;
}
}
if(count == a)
System.out.println("All Even");
else
System.out.println("Not All Even");
}
}