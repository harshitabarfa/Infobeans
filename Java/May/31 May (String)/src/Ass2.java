import java.util.*;

class Ass2
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter a string: ");
String s = sc.nextLine();

String r = "";
String w = "";

for(int i = 0; i<s.length(); i++)
{
char ch = s.charAt(i);

if(ch != ' ')
{
w = ch+w;
}
else
{
r += w + " ";
w = "";
}
}
r += w;
System.out.println(r);
}
}









