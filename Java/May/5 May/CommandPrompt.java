class CommandPrompt
{
public static void main(String a[])
{
System.out.println(a.length);

// for(String s : a)
// {
// System.out.println(s);
// }

// System.out.println(a[0]+a[1]);

int x = Integer.parseInt(a[0]);
int y = Integer.parseInt(a[1]);

// double x = Double.parseDouble(a[0]);
// double y = Double.parseDouble(a[1]);

if(a.length>3)
{
System.out.println("Wrong input");
System.exit(0); // Code exit kar dega
}

System.out.println(x+y);
System.out.println(x*y);

}
}