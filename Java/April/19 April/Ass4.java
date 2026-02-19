import java.util.*;

class Ass4
{
public static void main(String args[])
{ 
Scanner sc = new Scanner(System.in);

System.out.print("Enter a number: ");
int n = sc.nextInt();

int a = 0;
int b = 1;
int c;
System.out.print(a + " " + b);

int i = 2;

while(i<n)
{
c = a+b;
System.out.print(" "+c);
a=b;
b=c;
i++;
}

}
}