import java.util.*;

class Ass1
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
System.out.print("Enter a number: ");
int num = sc.nextInt();

int n = num;
int sum = 0;

while(num>0)
{
int d = num%10;
int fact = 1;

for (int i = 1; i <= d; i++) 
{
fact *= i;
}

sum += fact;
num/=10;
}

if (sum == n) 
{
System.out.println(n + " is a Strong Number.");
} 
else 
{
System.out.println(n + " is not a Strong Number.");
}
}
}
