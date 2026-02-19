import java.util.*;

public class Ass5
{
    public static void validateGrade(int grade) 
    {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Invalid grade: " + grade);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter grade: ");
        String grade = sc.nextLine();

        try 
        {
            int g = Integer.parseInt(grade);

            validateGrade(g);

            System.out.println("Grade for " + name + ": " + g);

        } 
        catch (NumberFormatException e) 
        {
            System.out.println("Invalid input: " + e.getMessage());
        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("Invalid grade: " + e.getMessage());
        }
    }
}
