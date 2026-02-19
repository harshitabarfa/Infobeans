package com.calculate;

import com.Math.Add;
import com.Math.Sub;
import com.Math.Mul;
import com.Math.Div;

import java.util.*;

public class Development
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter first number: ");
int a = sc.nextInt();
System.out.print("Enter second number: ");
int b = sc.nextInt();

Add add = new Add(a,b);
Sub sub = new Sub(a,b);
Mul mul = new Mul(a,b);
Div div = new Div(a,b);

System.out.println("Addition: " + add.perform());
System.out.println("Subtraction: " + sub.perform());
System.out.println("Multiplication: " + mul.perform());
System.out.println("Division: " + div.perform());
}
}













