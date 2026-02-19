import java.util.*;

public class Ass3 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the main string: ");
        String s = sc.nextLine();

        System.out.print("Enter the substring to replace: ");
        String s1 = sc.nextLine();

        System.out.print("Enter the new substring: ");
        String s2 = sc.nextLine();

        String result = "";
        int i = 0;

        while (i <= s.length() - s1.length()) 
        {
            boolean match = true;
            for (int j = 0; j < s1.length(); j++) 
            {
                if (s.charAt(i + j) != s1.charAt(j)) 
                {
                    match = false;
                    break;
                }
            }

            if (match) {
                result += s2;
                i += s1.length();
            } else {
                result += s.charAt(i);
                i++;
            }
        }

        while (i < s.length()) {
            result += s.charAt(i);
            i++;
        }

        System.out.println("Modified string: " + result);
    }
}
