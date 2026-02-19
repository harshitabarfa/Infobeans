import java.util.*;

class Ass2 
{
public static void main(String[] args) 
{
Scanner sc = new Scanner(System.in);
System.out.print("Enter a number: ");
int n = sc.nextInt();
int count = 0;

int i = 1; 

/*while (i <= n) 
{
if (n % i == 0) 
{
count++;
}
i++;
}*/

/*do
{
if (n % i == 0) 
{
count++;
}
i++;
}while(i <= n);*/

for(; i <= n; i++)
{
if (n % i == 0) 
{
count++;
}
}

System.out.println(count);
}
}
