import java.util.*;

class Ass9
{
public static void main(String args[])
{

Scanner sc = new Scanner(System.in);

System.out.print("Enter age: ");
int a = sc.nextInt();

if(a >= 0 && a<5)
System.out.println("Free Entry!");

else if(a >= 5 && a<=17)
System.out.println("Entry fee is 50");

else if(a >= 18 && a<=60)
System.out.println("Entry fee is 120");

else if(a > 60)
System.out.println("Entry fee is 80");

else
System.out.println("Invalid age!");
}
}
