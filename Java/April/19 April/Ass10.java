import java.util.*;

class Ass10
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
System.out.print("Enter a number: ");
int n = sc.nextInt();

for(int i=1; i<=n; i++)
{
for(int j=1; j<=i; j++)
{
if(i%2==0)
{
System.out.print("*");
}
else
System.out.print(j);
}
System.out.println();
}

}
}

