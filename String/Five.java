// Compare two strings (case-sensitive).

import java.util.*;

public class Five {
public static void main(String args[]) {
Scanner sc = new Scanner(System.in);

System.out.print("Enter your string: ");
String s = sc.nextLine();

System.out.print("Enter other string: ");
String s1 = sc.nextLine();

System.out.println(s.equalsIgnoreCase(s1));
}
}