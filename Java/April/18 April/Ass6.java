import java.util.*;

class Ass6{
public static void main(String[] args) 
{
Scanner sc = new Scanner(System.in);
System.out.print("Enter a number: ");
int n = sc.nextInt();
int count = 0;

while(n>0) 
{
int d = n % 10;
if (d==2 || d==3 || d==5 || d==7) 
{
count++;
}
n/=10;
}

if (count >= 2) 
{
System.out.println("Access Code Accepted: " + count + " prime digits found.");
}
else 
{
System.out.println("Access Denied: Only " + count + " prime digit found.");
}
}
}
