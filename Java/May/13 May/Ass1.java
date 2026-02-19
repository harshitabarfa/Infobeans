import java.util.*;

class Customer
{
protected int amount;

Customer(int amount)
{
this.amount = amount;
}

public int calculateLoyaltyPoints()
{
return amount/10;
}
}

class PremiumCustomer extends Customer
{
PremiumCustomer(int amount)
{
super(amount);
}

public int calculateLoyaltyPoints()
{
return 2*(amount/10);
}
}

class Ass1
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
System.out.print("Enter amount spent: ");
int amount = sc.nextInt();
sc.nextLine();

System.out.print("Customer is premium or not: ");
String s = sc.nextLine();


Customer c;
if (s.equalsIgnoreCase("yes")) 
{
c = new PremiumCustomer(amount);
System.out.println("Points for premium customer: " + c.calculateLoyaltyPoints());

} 
else 
{
c = new Customer(amount);
System.out.println("Points for regular customer: " + c.calculateLoyaltyPoints());
}

}
}
















