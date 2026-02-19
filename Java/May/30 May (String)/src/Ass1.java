import java.util.*;

class Demo
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter a string: ");
String s = sc.nextLine();

boolean counted[] = new boolean[256];

for(int i = 0; i<s.length(); i++)
{
char ch = s.charAt(i);

if(ch>='A' && ch<='Z')
{
ch = (char)(ch+32);
}

if(counted[ch])
{
continue;
}
counted[ch] = true;

int count = 0;
for(int j = 0; j<s.length(); j++)
{
char ch2 = s.charAt(j);

if(ch2>='A' && ch2<='Z')
{
ch2 = (char)(ch2+32);
}

if(ch2==ch)
{
count++;
}
}
System.out.println(ch + " " + count);
}

}
}









