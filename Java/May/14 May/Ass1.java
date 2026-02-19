import java.util.*;

abstract class Appliance 
{
String brand;
boolean isOn;

Appliance(String brand) 
{
this.brand = brand;
this.isOn = false;
}

public void turnOn() 
{
isOn = true;
System.out.println("The appliance is now ON.");
}

public void turnOff() 
{
isOn = false;
System.out.println("The appliance is now OFF.");
}

abstract public void operate();
}

class WashingMachine extends Appliance {

WashingMachine(String brand) {
super(brand);
}

public void operate() 
{
System.out.println("The washing machine is washing clothes.");
}
}

class Refrigerator extends Appliance 
{
Refrigerator(String brand) 
{
super(brand);
}

public void operate() 
{
System.out.println("The refrigerator is cooling items.");
}
}

public class Ass1 
{
public static void main(String[] args) 
{
WashingMachine w = new WashingMachine("LG");
System.out.println("Washing machine:");
w.turnOn();
w.operate();
w.turnOff();

System.out.println();

Refrigerator r = new Refrigerator("Samsung");
System.out.println("Refrigerator:");
r.turnOn();
r.operate();
r.turnOff();
}
}