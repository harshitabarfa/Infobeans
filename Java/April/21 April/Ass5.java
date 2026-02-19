import java.util.*;

class Ass5
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
int sum = 0;
int orgNum = n;

while (n > 0) 
{
int d = n % 10;                
int fact = 1;

for (int i = 1; i <= d; i++) 
{
fact *= i;
}

sum += fact;
n /= 10;
}

if (sum == orgNum) 
{
System.out.println(orgNum); 
}

n = orgNum;
}

}
}
