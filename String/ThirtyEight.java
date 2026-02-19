import java.util.*;

public class ThirtyEight
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter string: ");
String s = sc.nextLine();

for(int i = s.length()-1; i>=0; i--)
{
char ch = s.charAt(i);

if(ch != ' ')
System.out.print(ch + " ");
}

}
} 













