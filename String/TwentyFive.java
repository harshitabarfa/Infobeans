// Count total words in a string.

import java.util.*;

public class TwentyFive {
public static void main(String args[]) {
Scanner sc = new Scanner(System.in);

System.out.print("Enter a string: ");
String s = sc.nextLine();

String[] words = s.trim().split("\\s+");
System.out.println(words.length);
}
}
