import java.util.*;

public class Fourty
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter string: ");
String s = sc.nextLine();

String s1 = sc.nextLine();

for(int i = 0; i<s.length(); i++)
{
char ch1 = s.charAt(i);

if(ch1 == s1.charAt(0))
System.out.print(i + " ");
}

}
} 













