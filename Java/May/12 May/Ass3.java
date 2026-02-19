class Bank
{
public int getInterestRate()
{
return 0;
}
}

class SBI extends Bank
{
public int getInterestRate()
{
return 5;
}
}

class ICICI extends Bank
{
public int getInterestRate()
{
return 6;
}
}

class Axis extends Bank
{
public int getInterestRate()
{
return 7;
}
}

class Ass3
{
public static void main(String args[])
{
Bank b1 = new Bank();
System.out.println(b1.getInterestRate());
Bank b2 = new SBI();
System.out.println(b2.getInterestRate());
Bank b3 = new ICICI();
System.out.println(b3.getInterestRate());
Bank b4 = new Axis();
System.out.println(b4.getInterestRate());
}
}