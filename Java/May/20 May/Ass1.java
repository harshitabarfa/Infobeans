import java.util.*;

interface PaymentGateway
{
void processPayment(double amount);
}

class CreditCardPayment implements PaymentGateway
{
public void processPayment(double amount)
{
System.out.println("Processing credit card payment of: " +amount);
}
}

class UPIPayment implements PaymentGateway
{
public void processPayment(double amount)
{
System.out.println("Processing UPI payment of: " +amount);
}
}

class Ass1
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter payment method (Credit/UPI): ");
String method = sc.nextLine().toLowerCase();

System.out.print("Enter amount: ");
double amount = sc.nextDouble();

PaymentGateway p;

if(method.equals("credit"))
{
p = new CreditCardPayment();
}
else if(method.equals("upi"))
{
p = new UPIPayment();
}
else
{
System.out.println("Invalid payment method");
return;
}
p.processPayment(amount);
}
}

















