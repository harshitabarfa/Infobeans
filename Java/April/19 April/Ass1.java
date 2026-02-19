
import java.util.*;

class Ass1
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
System.out.print("Enter a start point: ");
int start = sc.nextInt();

System.out.print("Enter a end point: ");
int end = sc.nextInt();

int count = 0;

for(int n=start; n<=end; n++)
{
int a = n;
int rev = 0;
while(a>0)
{
rev = rev * 10 + a % 10;
a = a/10;
}

if(n==rev)
{
System.out.println("Found Palindrome Key: " +rev+ " - Magic Gate Reacts!");
count++;
}

}

if(count==0)
{
System.out.println("No Palindrome Keys Found in the Given Range.");
}
}}