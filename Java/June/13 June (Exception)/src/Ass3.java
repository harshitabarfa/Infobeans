import java.util.*;

class InvalidAgeForDrivingLicenseException extends Exception 
{
    public InvalidAgeForDrivingLicenseException(String message) 
    {
        super(message);
    }
}

class InvalidMarkForDrivingLicenseException extends Exception 
{
    public InvalidMarkForDrivingLicenseException(String message) 
    {
        super(message);
    }
}
 
class Ass3
{
	public static void main(String a[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter name: ");
		String name = sc.nextLine();
		
		System.out.print("Enter age: ");
        int age = sc.nextInt();
        
        System.out.print("Enter mark: ");
        int mark = sc.nextInt();
        

        try 
        {
            if (age < 0) 
            {
                throw new InvalidAgeForDrivingLicenseException("InvalidAgeForDrivingLicenseException: Invalid age");
            } 
            else if (age <= 18) 
            {
                throw new InvalidAgeForDrivingLicenseException("InvalidAgeForDrivingLicenseException: Age should be more than 18 years old");
            }

            if (mark < 0 || mark > 100)
            {
                throw new InvalidMarkForDrivingLicenseException("InvalidMarkForDrivingLicenseException: Invalid mark");
            } 
            else if (mark <= 80) 
            {
                throw new InvalidMarkForDrivingLicenseException("InvalidMarkForDrivingLicenseException: Mark should be more than 80");
            }

            System.out.println("Approved");
        } 
        catch (InvalidAgeForDrivingLicenseException | InvalidMarkForDrivingLicenseException e) 
        {
            System.out.println(e.getMessage());
        }
	}
}