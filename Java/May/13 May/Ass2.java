import java.util.*;

class Pizza
{
protected double basePrice;
protected double toppingCost;
protected int numberOfToppings;

Pizza(double basePrice, double toppingCost, int numberOfToppings)
{
this.basePrice = basePrice;
this.toppingCost = toppingCost;
this.numberOfToppings = numberOfToppings;
}

public double calculatePrice()
{
return basePrice + (toppingCost * numberOfToppings);
}
}

class DiscountPizza extends Pizza
{
DiscountPizza(double basePrice, double toppingCost, int numberOfToppings)
{
super(basePrice, toppingCost, numberOfToppings);
}

public double calculatePrice()
{
double price = super.calculatePrice();

if(numberOfToppings > 3)
{
price = price*0.9;
}
return price;
}
}

class Ass2
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

double basePrice = sc.nextDouble();
double toppingCost = sc.nextDouble();
int numberOfToppings = sc.nextInt();

Pizza p = new Pizza(basePrice, toppingCost, numberOfToppings);
double regularPrice = p.calculatePrice();

DiscountPizza p1 = new DiscountPizza(basePrice, toppingCost, numberOfToppings);
double DiscountPrice = p1.calculatePrice();

System.out.println("Regular price for pizza: " +regularPrice);
System.out.println("Discount price for pizza: " +DiscountPrice); 
}
}
















