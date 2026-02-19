import java.util.*;

class Ass2
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

System.out.println("Sum of all elements are: ");
int sum = 0;
i = 0;
while(i<b.length)
{
sum += b[i];
i++;
}
System.out.print(sum); */

int i = 0;
do
{
b[i] = sc.nextInt();
i++;
}while(i<b.length);

System.out.println("Sum of all elements are: ");
int sum = 0;
i = 0;
do
{
sum += b[i];
i++;
}while(i<b.length);
System.out.print(sum);

}
}