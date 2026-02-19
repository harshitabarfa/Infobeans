class p27
{
public static void main(String args[])
{
for(int i = 1; i<=5; i++)
{
for(int j = 1; j<=i; j++)
{
if(i==5)
{
System.out.print(j % 2 == 1 ? "1" : "0");
}
else
{
if(j==1 || j==i)
{
System.out.print((i + j) % 2 == 0 ? "1" : "0");
}
else
{
System.out.print(" ");
}

}
}
if(i==5)
{
System.out.println("+");
}
System.out.println();
}

}
}