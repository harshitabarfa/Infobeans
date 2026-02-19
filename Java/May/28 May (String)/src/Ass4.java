import java.util.*;

class Ass4
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter a string: ");
String s = sc.nextLine();


for(int i = 0; i<s.length(); i++)
{
char ch = s.charAt(i);

if(ch==' ')
{
continue;
}
System.out.print(ch);
}

}
}