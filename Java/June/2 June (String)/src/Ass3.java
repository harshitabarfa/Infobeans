import java.util.*;

public class Ass3 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String s = sc.nextLine();

        String words[] = s.split(" ");
        
        for (int i = 1; i < words.length; i += 2) 
        {
            StringBuilder sb = new StringBuilder(words[i]);
            words[i] = sb.reverse().toString();
        }

        String modified = String.join(" ", words);
        System.out.println(modified);
    }
}
