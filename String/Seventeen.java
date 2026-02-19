// Remove occurrence of a character.

import java.util.*;

public class Seventeen {
public static void main(String args[]) {
Scanner sc = new Scanner(System.in);

System.out.print("Enter a string: ");
String s = sc.nextLine();

System.out.print("Enter character: ");
char s1 = sc.next().charAt(0);

System.out.println(s.replaceAll(Character.toString(s1), ""));

}
}