import java.io.*;
import java.util.Scanner;

public class Ass5
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        File f = new File("Students.txt");

        if (!f.exists()) 
        {
            System.out.println("File does not exist!");
            return;
        }

        System.out.print("Enter the word to search: ");
        String sWord = sc.next().toLowerCase();

        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(f))) 
        {
            String line;

            while ((line = reader.readLine()) != null) 
            {
                String[] w = line.toLowerCase().split(",");

                for (String w1 : w) 
                {
                    if (w1.equals(sWord)) 
                    {
                        count++;
                    }
                }
            }

            System.out.println("The word " + sWord + " appears " + count + " times.");

        } 
        catch (IOException e) 
        {
            System.out.println("Error!");
        }
    }
}
