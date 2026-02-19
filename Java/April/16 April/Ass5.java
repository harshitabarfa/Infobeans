import java.util.*;

class Ass5
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter number: ");
int Number = sc.nextInt();
int m = Number;
int rev = 0;

/* while(Number>0)
{
rev = rev * 10 + Number % 10;
Number = Number/10;
}
if(m==rev)
System.out.println("Number is palindrome");
else
System.out.println("Number is not palindrome"); */

/* do 
{
rev = rev * 10 + Number % 10;
Number = Number/10;
} while(Number>0);
if(m==rev)
System.out.println("Number is palindrome");
else
System.out.println("Number is not palindrome"); */

for(; Number>0; Number = Number/10)
{
rev = rev * 10 + Number % 10;
}
if(m==rev)
System.out.println("Number is palindrome");
else
System.out.println("Number is not palindrome");

}
}