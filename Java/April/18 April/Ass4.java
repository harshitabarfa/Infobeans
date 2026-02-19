import java.util.*;

class Ass4
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter number: ");
int num = sc.nextInt();

int sq = num*num;
int sum = 0;

/*while(sq>0)
{
int d = sq%10;
sum += d;
sq/=10;
}*/

/*do
{
int d = sq%10;
sum += d;
sq/=10;
}while(sq>0);*/

for(; sq>0; sq=sq/10)
{
int d = sq%10;
sum += d;
}

if(sum==num)
System.out.print("Glowing Success! You've found the Neon Number!");
else
System.out.print("Try again! Not quite glowing yet.");

}
}