import java.util.*;

class UnderageException extends Exception 
{
    public UnderageException(String message) 
    {
        super(message);
    }
}

class DrivingLicense 
{
    public void verifyAge(int age) throws UnderageException 
    {
        if (age < 0) 
        {
            throw new UnderageException("UnderageException: Invalid age entered");
        }
        else if (age < 18) 
        {
            throw new UnderageException("UnderageException: Age must be 18 or above to apply for a license");
        } 
        else 
        {
            System.out.println("Eligible for driving license");
        }
    }
}

public class Ass7 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        DrivingLicense dl = new DrivingLicense();

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        try 
        {
            dl.verifyAge(age);
        } 
        catch (UnderageException e) {
            System.out.println(e.getMessage());
        }
    }
}
