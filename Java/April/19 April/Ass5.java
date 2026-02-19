import java.util.*;

class Ass5
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
System.out.print("Enter the start number: ");
int a = sc.nextInt();

System.out.print("Enter the end number: ");
int b = sc.nextInt();

int c;

for(int i=a; i<=b; i++)
{
System.out.println("Multiplication table of " +i+ ":");
for(int j=1; j<=10; j++)
{
c = i*j;
System.out.println(i + "*" + j + "=" +c);
}
System.out.println(" ");
}

}
}

