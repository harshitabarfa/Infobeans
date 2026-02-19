import java.io.*;

public class Ass3 
{
    public static void main(String[] args) 
    {
        File f = new File("Students.txt");
        File df = new File("destination.txt");

        if (!f.exists()) 
        {
            System.out.println("Source file does not exist.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f));
            PrintWriter pw = new PrintWriter(df)) 
        {
            String line;
            while ((line = br.readLine()) != null) 
            {
                pw.print(line);
                pw.println();
            }
            System.out.println("File copied successfully!");
        } 
        catch (IOException e) 
        {
            System.out.println("Error!");
        }
    }
}

