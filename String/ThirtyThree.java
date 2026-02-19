import java.util.*;

public class ThirtyThree
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter string: ");
String s = sc.nextLine();

String s1[] = s.split(" ");

String longestWord = "";
int maxLen = 0;

for(String s2 : s1)
{
if(s2.length() > maxLen)
{
maxLen = s2.length();
longestWord = s2;
}
}

System.out.println(longestWord);

}
} 













