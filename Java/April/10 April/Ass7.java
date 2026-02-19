import java.util.*;

class Ass7
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
System.out.print("Enter a 3-digit number: ");

int num = sc.nextInt();

int hundreds = num / 100;
int tens = (num % 100) / 10;
int units = num % 10;

System.out.println("Hundreds digit : " +hundreds);

System.out.println("Tens digit : " +tens);

System.out.println("Units digit : " +units);
}
}


