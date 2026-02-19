import java.util.*;

public class ThirtyFour
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter string: ");
String s = sc.nextLine();

String s1[] = s.split(" ");

String shortestWord = "";
int minLen = Integer.MAX_VALUE;
String already = "";

for(String s2 : s1)
{
if(already.indexOf(s2) != -1)
continue;

if(s2.length() < minLen)
{
shortestWord = s2;
minLen = s2.length();
}
}

for(String s2 : s1)
{
if(s2.length() == minLen)
{
System.out.println(shortestWord + " ");
already += s2 + " ";
}
}

}
} 













