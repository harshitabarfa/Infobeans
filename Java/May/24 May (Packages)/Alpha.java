package com1.Specifiers;

public class Alpha
{
public void display()
{
Test t = new Test();

// System.out.println("Private: " + t.a);
System.out.println("Protected: " + t.b);
System.out.println("Default: " + t.c);
System.out.println("Public: " + t.d);
}
}
