// Get the Unicode code point of a character at index.

import java.util.*;

public class Twelve {
public static void main(String args[]) {
Scanner sc = new Scanner(System.in);

System.out.print("Enter a string: ");
String s = sc.nextLine();

System.out.print("Enter index: ");
int s1 = sc.nextInt();


System.out.println(s.codePointAt(s1));
}
}