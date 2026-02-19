interface Calculator 
{
static int add(int a, int b) 
{
return a + b;
}

default int subtract(int a, int b) 
{
return a - b;
}
}

class BasicCalculator implements Calculator {
}

class Ass2 
{
public static void main(String[] args) 
{
int sum = Calculator.add(10, 5);
System.out.println("Sum: " + sum);

BasicCalculator cal = new BasicCalculator();
int diff = cal.subtract(10, 5);
System.out.println("Difference: " + diff);
}
}
