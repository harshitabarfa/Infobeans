import java.util.*;

class Ass8
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
System.out.print("Enter number: ");
int num = sc.nextInt();

int n = num;
int count = 0;

while(n > 0)
{
int digit = n % 10;
if (digit % 2 != 0)
count++;
n /= 10;
}
System.out.println(count);

/* do
{
int digit = n % 10;
if (digit % 2 != 0)
count++;
n /= 10;
}
while(n>0);
System.out.println(count); */

/* for(; n>0; n=n/10)
{
int digit = n % 10;
if (digit % 2 != 0)
count++;
}
System.out.println(count); */
}
}