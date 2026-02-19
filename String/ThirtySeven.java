import java.util.*;

public class ThirtySeven
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter string: ");
String s = sc.nextLine();

String s1[] = s.split(" ");

for(String s2 : s1)
{
String rev = "";
for(int i = s2.length()-1; i>=0; i--)
{
rev += s2.charAt(i);
}
System.out.print(rev + " ");
}

}
} 













