import java.util.*;

public class ThirtyNine
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter string: ");
String s = sc.nextLine();

char ch = sc.next().charAt(0);

for(int i = 0; i<s.length(); i++)
{
char ch1 = s.charAt(i);

if(ch1 == ch)
System.out.print(i + " ");
}

}
} 













