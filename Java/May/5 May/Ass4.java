import java.util.*;

class Sphere 
{
public static double cal_Volume(int radius) 
{
return (4.0 / 3.0) * 3.14 * radius * radius * radius;
}

public static double cal_Volume(double radius) 
{
return (4.0 / 3.0) * 3.14 * radius * radius * radius;
}

public static double cal_SurfaceArea(int radius) 
{
return 4 * 3.14 * radius * radius;
}

public static double cal_SurfaceArea(double radius) 
{
return 4 * 3.14 * radius * radius;
}

}

class Ass4 
{
public static void main(String[] args) 
{
Scanner sc = new Scanner(System.in);

int p = sc.nextInt();
double q = sc.nextDouble();

double vol1 = Sphere.cal_Volume(p);
double vol2 = Sphere.cal_Volume(q);

double sa1 = Sphere.cal_SurfaceArea(p);
double sa2 = Sphere.cal_SurfaceArea(q);

System.out.printf("%.2f %.2f\n", vol1, vol2);
System.out.printf("%.2f %.2f\n", sa1, sa2);

}
}
