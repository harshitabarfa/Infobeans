import java.util.*;

class Ass6
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter a lowercase letter: ");
char n = sc.next().charAt(0);

for(char i='a'; i<=n; i++)
{
for(char j='a'; j<=i; j++)
{
System.out.print(j);
}
System.out.println();
}

}
}

