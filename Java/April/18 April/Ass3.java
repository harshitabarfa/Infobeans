import java.util.*;

class Ass3
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter number: ");
int steps = sc.nextInt();

int sum = 0;
int i = 1;

while(i<=steps/2)
{
if(steps%i==0)
{
sum += i;
}
i++;
}

/*do
{
if(steps%i==0)
{
sum += i;
}
i++;
}while(i<=steps/2);*/

/*for(; i<=steps/2; i++)
{
if(steps%i==0)
{
sum += i;
}
}*/

if(sum==steps)
System.out.print("Perfect Day! You have earned the badge!");
else
System.out.print("Not a perfect day, but keep going!");

}
}