import java.util.*;

abstract class Payment
{ 
double amount;
String transactionid;

public Payment(double amount,String transactionid)
{ 
this.amount=amount;
this.transactionid=transactionid;
}

abstract void processPayment();

void displaydetails()
{
System.out.println("Transaction id "+transactionid);    
System.out.println("Amount "+amount);
} 
}

class CreditcardPayment extends Payment
{  
String cardNumber;

public CreditcardPayment(double amount,String transactionid)
{ 
super(amount,transactionid);
this.cardNumber = cardNumber;
}

void processPayment()
{ 
System.out.println("Processing credit card payment for amount: "+amount);
} 
}

class PaypalPayment extends Payment 
{ 
String paypalid;

public PaypalPayment(double amount,String transactionid)
{ 
super(amount,transactionid);
this.paypalid = paypalid;
}

void processPayment()
{
System.out.println("Processing paypal payment for amount : "+amount);
}
}

class Ass2
{ 
public static void main(String args[])
{ 
Payment c=new CreditcardPayment(25.000,"Kuch bhi");
Payment pp=new PaypalPayment(40.000,"Again kuchbhi");
System.out.println("For credit card ");

c.processPayment();
c.displaydetails();
System.out.println();
System.out.println("For paypal card ");
pp.processPayment();
pp.displaydetails();
}
}