import java.util.*;

class Ass4
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter a number: ");
int a = sc.nextInt();

int[] b = new int[a];
System.out.println("Length: " +b.length);
System.out.println("Enter elements: ");

int i = 0;
while(i<b.length)
{
b[i] = sc.nextInt();
i++;
}

System.out.println("Even elements are: ");

i = 0;
while(i<b.length)
{
if(b[i]%2==0)
{
System.out.println(b[i]);
}
i++;
}

/* int i = 0;
do
{
b[i] = sc.nextInt();
i++;
}while(i<b.length);

System.out.println("Even number are:");
i = 0;
do
{
if(b[i]%2==0)
{
System.out.println(b[i]);
}
i++;
}while(i<b.length); */

}
}