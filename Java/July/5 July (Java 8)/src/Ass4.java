import java.util.*;
import java.util.function.Consumer;

class Transaction
{
	private int accountNumber;
	private double amount;
	private String type;
	
	public int getAccountNumber() 
	{
		return accountNumber;
	}
	
	public void setAccountNumber(int accountNumber) 
	{
		this.accountNumber = accountNumber;
	}
	
	public double getAmount() 
	{
		return amount;
	}
	
	public void setAmount(double amount)  
	{
		this.amount = amount;
	}
	
	public String getType() 
	{
		return type;
	}
	
	public void setType(String type) 
	{
		this.type = type;
	}

	public Transaction(int accountNumber, double amount, String type) 
	{
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.type = type;
	}

	public String toString() 
	{
		return "Transaction [accountNumber=" + accountNumber + ", amount=" + amount + ", type=" + type + "]";
	}

	@Override
	public int hashCode() 
	{
		return Objects.hash(accountNumber, amount, type);
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return accountNumber == other.accountNumber
				&& Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(type, other.type);
	}
}

public class Ass4 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many customer transaction you want? ");
		int n = Integer.parseInt(sc.nextLine());
		
		ArrayList<Transaction> a = new ArrayList<>();
		
		for(int i = 0; i<n; i++)
		{
			System.out.println("\nTransaction " + (i+1) + " : ");
			
			System.out.print("Enter account number: ");
			int accountNumber = Integer.parseInt(sc.nextLine());
			
			System.out.print("Enter amount: ");
			double amount = Double.parseDouble(sc.nextLine());
			
			System.out.print("Enter type(deposit or withdraw): ");
			String type = sc.nextLine();
			
			if(!(type.equalsIgnoreCase("deposit") || type.equalsIgnoreCase("withdraw")))
			{
				System.out.println("Invalid type. Please enter 'deposit' or 'withdraw'.");
				System.out.print("\nEnter type (deposit or withdraw): ");
                type = sc.nextLine();
			}
			
			Transaction t = new Transaction(accountNumber, amount, type);
			a.add(t);
		}
		
		Consumer<Transaction> c = e -> {
			System.out.println("Account number: " + e.getAccountNumber() +
			", Amount: " + e.getAmount() + ", Type: " + e.getType());
		};
		
		System.out.println("\nDisplay details: ");
		for(Transaction t : a)
		{
			c.accept(t);
		}
	}
}




















