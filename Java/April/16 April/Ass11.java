import java.util.*;

public class Ass11 {
public static void main(String[] args) 
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter number: ");
int number = sc.nextInt();

System.out.print("Enter digit: ");
int digit = sc.nextInt();

int count = 0;
int n = number;

/* while (n > 0) 
{
int result = n % 10;
if (result == digit) 
{
count++;
}
n /= 10;
}

System.out.println("Digit " + digit + " appears " + count + " times in " + number); */

/* do
{
int result = n % 10;
if (result == digit) 
{
count++;
}
n /= 10;
} while (n > 0);
System.out.println("Digit " + digit + " appears " + count + " times in " + number); */

for(; n>0; n=n/10)
{
int result = n % 10;
if (result == digit) 
{
count++;
}          
}
System.out.println("Digit " + digit + " appears " + count + " times in " + number);

}
}
