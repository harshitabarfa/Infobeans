import java.util.*;

public class ThirtyFive
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter string: ");
String s = sc.nextLine();

String s1[] = s.split(" ");

for(String s2 : s1)
{
String rev = new StringBuilder(s2).reverse().toString();
if(s2.equalsIgnoreCase(rev))
{
System.out.println(s2);
break;
}
}

}
} 













