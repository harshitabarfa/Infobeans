import java.util.*;

public class ThirtyTwo
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter string: ");
String s = sc.nextLine();

String s1[] = s.split(" ");

String counted = "";
for(String s2 : s1)
{
if(counted.indexOf(s2) != -1)
continue;

int count = 0;
for(String s3 : s1)
{
if(s2.equals(s3))
count++;
}

System.out.println(s2 + ": " + count);
counted += s2 + " ";
}

}
} 













