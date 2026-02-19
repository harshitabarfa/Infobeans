import java.util.*;

class Ass12
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter number: ");
int n = sc.nextInt();

int count = 1;

/* while(n>0)
{
int i = n%10;
count = count*i;
n = n/10;
}
System.out.println(count); */

/* do
{
int i = n%10;
count = count*i;
n = n/10;
}
while(n>0);
System.out.println(count); */

for(; n>0; n=n/10)
{
int i = n%10;
count = count*i;
}
System.out.println(count);

}
}