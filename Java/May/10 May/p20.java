class p20
{
public static void main(String args[])
{
for(int i = 1; i<=5; i++)
{
for(int j = 1; j<=i; j++)
{
if(j==1 || j==i || i==5)
{
System.out.print(j);
}
else
{
System.out.print(" ");
}
}
System.out.println();
}

}
}