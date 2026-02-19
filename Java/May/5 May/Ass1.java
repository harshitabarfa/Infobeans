class Amount
{
public void calculateInterest(double amount, int years)
{
double rate = 2.0;
System.out.println("Regular Savings Interest: " + (amount*years*rate)/100);
}

public void calculateInterest(double amount, int years,double rate)
{
System.out.println("Fixed Deposit Interest: " +(amount*years*rate)/100);
}

public void calculateInterest(double amount)
{
int years = 2;
double rate = 2.0;
System.out.println("Recurring Deposit Interest: " +(amount*years*rate)/100);
}
}

class Ass1
{
public static void main(String args[])
{
Amount a1 = new Amount();
a1.calculateInterest(230.0, 3);
a1.calculateInterest(234.3, 5, 3.4);
a1.calculateInterest(233.4);
}
}