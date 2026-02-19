import java.util.*;

class Ass3
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter start number: ");
int start = sc.nextInt();

System.out.print("Enter end number: ");
int end = sc.nextInt();

for(int i=start; i<=end; i++)
{
if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0))
{
System.out.println(i);
}
}

}
}

