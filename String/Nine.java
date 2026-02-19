// Check whether a string is empty.

import java.util.*;

public class Nine {
public static void main(String args[]) {
Scanner sc = new Scanner(System.in);

System.out.print("Enter a string: ");
String s = sc.nextLine();

System.out.print("Enter other string: ");
String s1 = sc.nextLine();

System.out.println(s.isEmpty());
System.out.println(s1.isEmpty());
}
}