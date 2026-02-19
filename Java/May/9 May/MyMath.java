class MyMath
{
public static void main(String args[])
{
int a = Math.max(10,20);
int b = Math.min(10,20);
double c = Math.pow(10,2);

// double d = Math.random();
int min = 1;
int max = 100;
int d = (int)(Math.random() * (max-min+1))+1;

double e = Math.sqrt(16);
double f = Math.abs(-15);

System.out.println(a);
System.out.println(b);
System.out.println(c);
System.out.println(d);
System.out.println(e);
System.out.println(f);
}
}