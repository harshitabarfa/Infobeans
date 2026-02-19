import java.util.*;

class Circle
{
public static double cal_Circumference(int radius)
{
return 2*3.14*radius;
}

public static double cal_Circumference(double radius)
{
return 2*3.14*radius;
}

public static double cal_Area(int radius)
{
return 3.14*radius*radius;
}

public static double cal_Area(double radius)
{
return 3.14*radius*radius;
}

}
class Ass3
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

int a = sc.nextInt();
double b = sc.nextDouble();

double d1 = Circle.cal_Circumference(a);
double d2 = Circle.cal_Circumference(b);
double c1 = Circle.cal_Area(a);
double c2 = Circle.cal_Area(b);

System.out.printf("%.2f %.2f\n", d1, d2);
System.out.printf("%.2f %.2f\n", c1, c2);
}
}