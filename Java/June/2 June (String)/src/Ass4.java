import java.util.*;

public class Ass4 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        for (int i = 0; i < s.length(); i++) 
        {
            char ch = s.charAt(i);
            int ascii = (int) ch;
            
            System.out.print(ascii + " ");
        }
    }
}
