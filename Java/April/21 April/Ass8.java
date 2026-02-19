import java.util.*;

class Ass8 
{
public static void main(String args[]) 
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter a number: ");
int n = sc.nextInt();

for (int i = 1; i <= n; i++) 
{
for (int j = 1; j <= n - i; j++) 
{
System.out.print("* ");
}

int num = n;
for (int j = 1; j <= i; j++) 
{
System.out.print(num + " ");
num--;
}

num = n - i + 2;
for (int j = 1; j < i; j++) 
{
System.out.print(num + " ");
num++;
}

System.out.println();
}

}
}
