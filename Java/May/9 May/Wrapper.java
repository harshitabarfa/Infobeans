class Wrapper 
{
public static void main(String args[])
{
Integer a = 5; // Automatically
// Integer a = Integer.valueOf(5); // Manual boxing

String str = a.toString();
System.out.println(str);
System.out.println(str.length());

/* Double b = 2.5;
Character c = 'H'; */

/* System.out.println(a);
System.out.println(b);
System.out.println(c); */

/* System.out.println(a.intValue());
System.out.println(b.doubleValue());
System.out.println(c.charValue()); */
}
}