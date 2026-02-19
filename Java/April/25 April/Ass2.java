import java.util.*;

class BankAccount 
{
private String accountHolder;
private long accountNumber;
private double balance;
private String accountType;
private boolean isActive;

public void setAccountHolder(String ach) 
{
accountHolder = ach;
}

public String getAccountHolder() 
{
return accountHolder;
}

public void setAccountNumber(long acNum) {
accountNumber = acNum;
}

public long getAccountNumber() 
{
return accountNumber;
}

public void setBalance(double b) 
{
balance = b;
}

public double getBalance() 
{
return balance;
}

public void setAccountType(String act) 
{
this.accountType = act;
}

public String getAccountType() 
{
return accountType;
}

public void setIsActive(boolean isActive) 
{
isActive = isActive;
}

public boolean getIsActive() 
{
return isActive;
}
}

class Ass2
{
public static void main(String[] args) 
{
Scanner sc = new Scanner(System.in);

BankAccount ac = new BankAccount();

System.out.print("Enter account holder's name: ");
String accountHolder = sc.nextLine();
        
ac.setAccountHolder(accountHolder);

System.out.print("Enter account number: ");
long accountNumber = sc.nextLong();
ac.setAccountNumber(accountNumber);

System.out.print("Enter balance: ");
double balance = sc.nextDouble();
ac.setBalance(balance);

sc.nextLine(); 
        
System.out.print("Enter account type (e.g., Savings, Checking): ");
String accountType = sc.nextLine();
ac.setAccountType(accountType);

System.out.print("Is the account active? (true/false): ");
boolean isActive = sc.nextBoolean();
ac.setIsActive(isActive);

System.out.println("Bank Account Details:");
System.out.println("Account Holder: " + ac.getAccountHolder());
System.out.println("Account Number: " + ac.getAccountNumber());
System.out.println("Balance: " + ac.getBalance());
System.out.println("Account Type: " + ac.getAccountType());

}
}
