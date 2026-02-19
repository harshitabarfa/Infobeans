class Bank
{
String accountHolder;
int accountNumber;
double balance;

public Bank(String accountHolder) 
{
this.accountHolder = accountHolder;
this.accountNumber = 0;
this.balance = 0.0;
}

public Bank(String accountHolder, int accountNumber) 
{
this.accountHolder = accountHolder;
this.accountNumber = accountNumber;
this.balance = 0.0;
}

public Bank(String accountHolder, int accountNumber, double balance) 
{
this.accountHolder = accountHolder;
this.accountNumber = accountNumber;
this.balance = balance;
}

public void displayAccountDetails() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
System.out.println();
}

}
class Ass3
{
public static void main(String args[])
{
Bank a1 = new Bank("Alice");
        System.out.println("Account 1:");       a1.displayAccountDetails();

Bank a2 = new Bank("Bob", 12345);        System.out.println("Account 2:");        a2.displayAccountDetails();

Bank a3 = new Bank("Charlie", 67890, 1000.50);
        System.out.println("Account 3:");
a3.displayAccountDetails();

}
}

