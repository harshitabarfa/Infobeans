// Find the highest frequency character.

import java.util.*;

public class Nineteen {
public static void main(String args[]) {
Scanner sc = new Scanner(System.in);

System.out.print("Enter a string: ");
String s = sc.nextLine();

char maxChar = ' ';
int maxCount = 0;

for(int i = 0; i<s.length(); i++)
{
char ch1 = s.charAt(i);
int count = 0;
for(int j = 0; j<s.length(); j++)
{
char ch2 = s.charAt(j);
if(ch1 == ch2)
{
count++;
}
}
if(count > maxCount)
{
maxCount = count;
maxChar = ch1;
}
}
System.out.println(maxChar + " " + maxCount);
}
}