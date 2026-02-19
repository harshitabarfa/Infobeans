import java.util.*;

public class TwentyEight
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter string: ");
String s = sc.nextLine();

String s1 = sc.nextLine();
int count = 0;
String s2[] = s.split(" ");

for(String s3 : s2)
{
if(s3.equalsIgnoreCase(s1))
count++;
}
System.out.println(count);
}
} 













