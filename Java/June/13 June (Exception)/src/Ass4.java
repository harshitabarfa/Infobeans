import java.util.*;

class NegativeDepositException extends Exception 
{
    public NegativeDepositException(String message) 
    {
        super(message);
    }
}

class InsufficientBalanceException extends Exception 
{
    public InsufficientBalanceException(String message) 
    {
        super(message);
    }
}

class BankAccount
{
	String accountNumber;
    String accountHolder;
    double balance;
    
	public BankAccount(String accountNumber, String accountHolder, double balance) 
	{
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = balance;
	}
	
	public void deposit(double amount) throws NegativeDepositException 
	{
        if (amount < 0) 
        {
            throw new NegativeDepositException("NegativeDepositException: Cannot deposit negative amount");
        }
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public void withdraw(double amount) throws InsufficientBalanceException 
    {
        if (amount > balance) 
        {
            throw new InsufficientBalanceException("InsufficientBalanceException: Not enough balance to withdraw");
        }
        balance -= amount;
        System.out.println("Withdrawal successful. New balance: " + balance);
    }
    
    public void showBalance() 
    {
        System.out.println("Current Balance: ₹" + balance);
    }
}

class Ass4
{
	public static void main(String a[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Account Number: ");
        String accountNumber = sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String accountHolder = sc.nextLine();

        System.out.print("Enter Initial Balance: ₹");
        double balance = sc.nextDouble();

        BankAccount account = new BankAccount(accountNumber, accountHolder, balance);
		
        int choice;
        do 
        {
        	System.out.println();
        	
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Exit");
            
            System.out.println();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            try 
            {
                switch (choice) 
                {
                    case 1:
                        System.out.print("Enter amount to deposit: ₹");
                        double dep = sc.nextDouble();
                        account.deposit(dep);
                        break;

                    case 2:
                        System.out.print("Enter amount to withdraw: ₹");
                        double with = sc.nextDouble();
                        account.withdraw(with);
                        break;

                    case 3:
                        account.showBalance();
                        break;

                    case 4:
                        System.out.println("Thank you for using our banking service!");
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } 
            catch (NegativeDepositException | InsufficientBalanceException e) 
            {
                System.out.println(e.getMessage());
            }

        } while (choice != 4);
	}
}