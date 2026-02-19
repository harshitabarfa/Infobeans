import java.util.*;

class Ass3
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter a number: ");
int a = sc.nextInt();

int[] b = new int[a];
System.out.println("Length: " +b.length);
System.out.println("Enter elements: ");

/* int i = 0;
while(i<b.length)
{
b[i] = sc.nextInt();
i++;
}

System.out.println("Multiplication of all elements are: ");
int m = 1;
i = 0;
while(i<b.length)
{
m *= b[i];
i++;
}
System.out.print(m); */

int i = 0;
do
{
b[i] = sc.nextInt();
i++;
}while(i<b.length);

System.out.println("Multiplication of all elements are: ");
int m = 1;
i = 0;
do
{
m *= b[i];
i++;
}while(i<b.length);
System.out.print(m);

}
}