   import java.util.*;

class Ass10
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
System.out.print("Enter first number: ");
int a = sc.nextInt();

System.out.print("Enter second number: ");
int b = sc.nextInt();

if (a > b) 
{
int c = a;
a = b;
b = c;
}

int i = a + 1;

/* while (i < b) 
{
if (i % 2 == 0)
System.out.print(i + " ");
i++;
} */

/* do
{
if (i % 2 == 0)
System.out.print(i + " ");
i++;
}
while(i < b); */

for(; i<b; i++)
{
if (i % 2 == 0)
System.out.print(i + " ");
}

}
}