// Find the last occurrence of a character.

import java.util.*;

public class Fifteen {
public static void main(String args[]) {
Scanner sc = new Scanner(System.in);

System.out.print("Enter a string: ");
String s = sc.nextLine();

System.out.print("Enter char: ");
char s1 = sc.next().charAt(0);

System.out.println(s.lastIndexOf(s1));
}
}