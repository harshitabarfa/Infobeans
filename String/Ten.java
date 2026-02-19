// Trim leading, trailing, or extra spaces.

import java.util.*;

public class Ten {
public static void main(String args[]) {
Scanner sc = new Scanner(System.in);

System.out.print("Enter a string: ");
String s = sc.nextLine();
String s1 = s.replaceAll("\\s+", " ");
System.out.println(s1.trim());
}
}