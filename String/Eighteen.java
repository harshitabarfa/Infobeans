// Replace occurrences of a character.

import java.util.*;

public class Eighteen {
public static void main(String args[]) {
Scanner sc = new Scanner(System.in);

System.out.print("Enter a string: ");
String s = sc.nextLine();

System.out.print("Replace: ");
char s1 = sc.next().charAt(0);

System.out.print("With new character: ");
char s2 = sc.next().charAt(0);

System.out.println(s.replace(s1, s2));

}
}