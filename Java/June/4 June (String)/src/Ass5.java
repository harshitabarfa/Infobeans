import java.util.*;

public class Ass5 
{
    public static void main(String[] args) 
    {
        String sentence = "Java is fun and powerful";
        String[] words = sentence.split(" ");
        String shortestWord = words[0];

        for (String word : words) 
        {
            if (word.length() < shortestWord.length()) 
            {
                shortestWord = word;
            }
        }

        System.out.println("Shortest word: " + shortestWord);
    }
}