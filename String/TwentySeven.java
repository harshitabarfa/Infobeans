import java.util.*;

public class TwentySeven
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter string: ");
String s = sc.nextLine();

String word = sc.nextLine();
int index = s.lastIndexOf(word);

System.out.println(index);
}
}













