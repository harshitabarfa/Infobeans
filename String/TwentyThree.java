// Print all characters that occur exactly twice.

import java.util.*;

public class TwentyThree {
public static void main(String args[]) {
Scanner sc = new Scanner(System.in);

System.out.print("Enter a string: ");
String s = sc.nextLine();

String twice = "";

for(int i = 0; i<s.length(); i++)
{
char ch1 = s.charAt(i);

if(twice.indexOf(ch1) != -1)
continue;

int count = 0;
for(int j = 0; j<s.length(); j++)
{
char ch2 = s.charAt(j);
if(ch1 == ch2)
{
count++;
}
}
if(count == 2)
{
System.out.println(ch1 + " ");
twice += ch1;
}
}

}
}








