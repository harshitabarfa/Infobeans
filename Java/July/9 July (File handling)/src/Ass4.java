import java.io.*;

public class Ass4 
{
    public static void main(String[] args) 
    {
        File f = new File("Students.txt");

        if (!f.exists()) 
        {
            System.out.println("File does not exist!");
            return;
        }

        int wCount = 0;
        int cCount = 0;

        try (BufferedReader r = new BufferedReader(new FileReader(f))) 
        {
            String line;

            while ((line = r.readLine()) != null) 
            {
                cCount += line.length();

                String[] words = line.trim().split(",");
                if (!line.trim().isEmpty()) 
                {
                    wCount += words.length;
                }
            }

            System.out.println("Total Characters: " + cCount);
            System.out.println("Total Words: " + wCount);

        } 
        catch (IOException e) 
        {
            System.out.println("Error!");
        }
    }
}
