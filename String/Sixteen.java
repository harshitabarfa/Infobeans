// Count total occurrence of a character.

import java.util.*;

public class Sixteen {
public static void main(String args[]) {
Scanner sc = new Scanner(System.in);

System.out.print("Enter a string: ");
String s = sc.nextLine();

System.out.print("Enter character: ");
char s1 = sc.next().charAt(0);

int count = 0;
for(int i = 0; i<s.length(); i++)
{
char ch = s.charAt(i);
if(ch == s1)
{
count++;
}
}
System.out.println(count);

}
}