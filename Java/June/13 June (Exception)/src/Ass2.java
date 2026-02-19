import java.util.*;

class DotException extends Exception 
{
    public DotException(String message) 
    {
        super(message);
    }
}

class AtTheRateException extends Exception 
{
    public AtTheRateException(String message) 
    {
        super(message);
    }
}

class DomainException extends Exception 
{
    public DomainException(String message) 
    {
        super(message);
    }
}

class Ass2 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter your e-mail: ");
        String email = sc.nextLine();

        try 
        {
            int count = 0;

            for (int i = 0; i < email.length(); i++) 
            {
                if (email.charAt(i) == '@') 
                {
                    count++;
                }
            }

            if (count != 1) 
            {
                throw new AtTheRateException("AtTheRateException: Invalid @ usage");
            }

            if (email.charAt(email.length() - 1) == '.') 
            {
                throw new DotException("DotException: Invalid Dot usage");
            }

            String domain3 = "";
            if (email.length() >= 3) 
            {
                domain3 += email.charAt(email.length() - 3);
                domain3 += email.charAt(email.length() - 2);
                domain3 += email.charAt(email.length() - 1);
            }

            String domain2 = "";
            if (email.length() >= 2) 
            {
                domain2 += email.charAt(email.length() - 2);
                domain2 += email.charAt(email.length() - 1);
            }

            if (!(domain3.equals("com") || domain3.equals("net") || domain3.equals("biz") || domain2.equals("in"))) 
            {
                throw new DomainException("DomainException: Invalid Domain");
            }

            System.out.println("Valid email address");
        } 
        catch (DotException | AtTheRateException | DomainException e) 
        {
            System.out.println(e.getMessage());
            System.out.println("Invalid email address");
        }
    }
}