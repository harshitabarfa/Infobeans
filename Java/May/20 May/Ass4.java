import java.util.*;

interface principal
{
double getPrincipal();
}

interface InterestRate
{
double getInterestRate();
}

class Loan implements principal, InterestRate
{
private double principal;
private double interestRate;

public Loan(double principal, double interestRate) 
{
this.principal = principal;
this.interestRate = interestRate;
}

public double getPrincipal() 
{
return principal;
}

public double getInterestRate() 
{
return interestRate;
}
}

class Ass4
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter principal: ");
double P = sc.nextDouble();

System.out.print("Enter rate: ");
double R = sc.nextDouble();

System.out.print("Enter time: ");
int T = sc.nextInt();

if (P <= 0 || R <= 0 || T <= 0 || P >= 1000000.0 || R < 0.01 || R > 0.99 || T >= 25) 
{
System.out.println("Invalid input values!");
} 

else 
{
Loan l = new Loan(P, R);

double totalInterest = l.getPrincipal() * l.getInterestRate() * T;

System.out.printf("Total interest paid: Rs.%.2f%n", totalInterest);
}
}
}




















