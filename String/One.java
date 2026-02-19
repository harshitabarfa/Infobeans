// Find the length of a string.

import java.util.*;

public class One {
public static void main(String args[]) {
Scanner sc = new Scanner(System.in);

System.out.print("Enter your string: ");
String s = sc.nextLine();
String result = s.replace(" ", "");

System.out.println("Length: " + result.length());
}
}