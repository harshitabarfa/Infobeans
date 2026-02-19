import java.util.*;

class Ass3
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter a number: ");
int n = sc.nextInt();

// int result = 1;
int i = 1;

// While loop:
while(i<=10)
{
int result = n*i;
System.out.println(n + "*" + i + "=" + result);
i++;
}

// For loop:
// for(i = 1; i<=10; i++)
// {
// result = n*i;
// System.out.println(n + "*" + i + "=" + result);
// }


// Do-while loop:
// do{
// result = n*i;
// i++;
// System.out.println(n + "*" + i + "=" + result);
// }
// while(i<=10);
}
}
