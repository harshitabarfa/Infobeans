 import java.util.*;

class NestedCondition
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
System.out.print("Enter First Number: ");
int a = sc.nextInt();

System.out.print("Enter Second Number: ");
int b = sc.nextInt();

System.out.print("Enter Third Number: ");
int c = sc.nextInt();

System.out.print("Enter Fourth Number: ");
int d = sc.nextInt();

System.out.print("Enter Fifth Number: ");
int e = sc.nextInt();

if(a>b)
{
    if(a>c)
    {
        if(a>d)
        {
           if(a>e)
           {
            System.out.println("a is greater.");
           }
           else
           {
            System.out.println("e is greater");
           }
        }
        else
        {
            if(d>e)
            {
                System.out.println("d is greater");
            }
            else
            {
                System.out.println("e is greater");
            }
        }
    }
    else
    {
        if(c>d)
        {
            if(c>e)
            {
                System.out.println("c is greater");
            }
            else
            {
                System.out.println("e is greater");
            }
        }
        else
        {
            if(d>e)
            {
               System.out.println("d is greater"); 
            }
            else
            {
                System.out.println("e is greater");
            }
        }
    }
}
else
{
    if(b>c)
    {
        if(b>d)
        {
            if(b>e)
            {
                System.out.println("b is greater");
            }
            else
            {
                System.out.println("e is greater");
            }
        }
        else
        {
            if(d>e)
            {
                System.out.println("d is greater");
            }
            else
            {
                System.out.println("e is greater");
            }
        }
    }
    else
    {
        if(c>d)
        {
            if(c>e)
            {
                System.out.println("c is greater");
            }
            else
            {
                System.out.println("e is greater");
            }
        }
        else
        {
            if(d>e)
            {
                System.out.println("d is greater");
            }
            else
            {
                System.out.println("e is greater");
            }
        }
    }
}

}
}


