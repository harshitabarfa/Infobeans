import java.util.*;

class Ass2
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter start number: ");
int start = sc.nextInt();

System.out.print("Enter end number: ");
int end = sc.nextInt();

int a = 0;

for(int i=start; i<=end; i++)
{
int num=i;
int count=0;
int org = i;
int sum = 0;

while(num>0)
{
count++;
num = num/10;
}

while(org>0)
{
int digit = org%10;
int power = 1;

for(int b = 1; b<=count; b++)
{
power *= digit;
}

sum += power;
org = org/10;
}

if(i==sum)
{
System.out.println("Launch Code Valid: " +i+ " is an Armstrong number!");
}
}
if(a == 0)
{
System.out.println("No valid launch codes found in the given range.");
}

}
}

