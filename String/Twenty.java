// Find the lowest frequency character.

import java.util.*;

public class Twenty {
public static void main(String args[]) {
Scanner sc = new Scanner(System.in);

System.out.print("Enter a string: ");
String s = sc.nextLine();

int minCount = s.length();

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
if(count < minCount)
{
minCount = count;
}
}


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
if(count == minCount)
{
System.out.println(ch1 + " ");
}
}

}
}










