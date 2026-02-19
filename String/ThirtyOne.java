import java.util.*;

public class ThirtyOne
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter string: ");
String s = sc.nextLine();

String s1[] = s.split(" ");
String result = "";

for(String s2 : s1)
{
if(result.indexOf(s2) == -1)
{
result += s2 + " ";
}
}
System.out.println(result.trim());
}
} 













