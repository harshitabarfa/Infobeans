import java.util.*;

class Demo
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter a string: ");
String s = sc.nextLine();

System.out.print("Enter a character: ");
char c = sc.next().charAt(0);

if(c>='A' && c<='Z')
{
c = (char)(c+32);
}

int count = 0;
for(int i = 0; i<s.length(); i++)
{
char ch = s.charAt(i);

if(ch>='A' && ch<='Z')
{
ch = (char)(ch+32);
}

if(ch==c)
{
count++;
}
}
System.out.println(count);
}
}