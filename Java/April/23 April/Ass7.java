import java.util.*;

class Ass7
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter numbers: ");
int n = sc.nextInt();

int a[] = new int[n];

System.out.print("Enter elements: ");

for(int i = 0; i<a.length; i++)
{
a[i] = sc.nextInt();
}

System.out.println("Reverse array are: ");

for(int i = a.length-1; 0<=i; i--)
{
System.out.print(a[i]+" ");
}

}
}