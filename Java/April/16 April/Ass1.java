import java.util.*;

class Ass1
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter a number: ");
int a = sc.nextInt();

int sum = 0;
int i = 0;

// While loop:
// while(i<=a)
// {
// sum += i;
// i++;
// }
// System.out.println(sum);

// For loop:
// for(i = 1; i<=a; i++)
// {
// sum+=i;
// }
// System.out.println(sum);

// Do-while loop:
do{
sum+=i;
i++;
}
while(i<=a);
System.out.println(sum);
}
}
