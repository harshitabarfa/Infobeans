package com1.Final;

import com1.Specifiers.Test;
import com1.Specifiers.Alpha;
import com1.Checking.Test2;
import com1.Checking.Test3;

public class Demo91
{
public static void main(String args[])
{
Test test = new Test();
Alpha alpha = new Alpha();
Test2 test2 = new Test2();
Test3 test3 = new Test3();

// System.out.println("Private: " + test.a);
// System.out.println("Protected: " + test.b);
// System.out.println("Default: " +test.c);
System.out.println("Public: " +test.d);

System.out.println("Private via getter method: " + test.getA());

System.out.println();

System.out.println("From alpha class: ");
alpha.display();

System.out.println();

System.out.println("From test2 class: ");
test2.display();

System.out.println();

System.out.println("From test3 class: ");
test3.display();
}
}








