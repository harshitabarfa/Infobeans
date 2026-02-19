import java.util.Scanner;

public class Ass4
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) 
        {
            if (c < '0' || c > '9') 
            {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}