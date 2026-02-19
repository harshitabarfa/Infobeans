import java.util.*;

class Ass6
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter size: ");
int n = sc.nextInt();

int a[] = new int[n];

System.out.println("Enter elements: ");

for(int i = 0; i<a.length; i++)
{
a[i] = sc.nextInt();
}

System.out.println("Maximum number is: ");
int max = a[0];

for(int i = 0; i<a.length; i++)
{
if(a[i]>max)
{
max = a[i];
}
}
System.out.println(max);


}
}