// Check if all characters in a string are unique.

import java.util.*;

public class TwentyFour {
public static void main(String args[]) {
Scanner sc = new Scanner(System.in);

System.out.print("Enter a string: ");
String s = sc.nextLine();

boolean unique = true;

for(int i = 0; i<s.length(); i++)
{
char ch1 = s.charAt(i);

for(int j = i+1; j<s.length(); j++)
{
char ch2 = s.charAt(j);
if(ch1 == ch2)
{
unique = false;
break;
}
}
if(!unique)
{
break;
}
}
System.out.println(unique);
}
}








