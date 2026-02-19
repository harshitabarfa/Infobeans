import java.util.*;

class Ass11
{
public static void main(String args[])
{

Scanner sc = new Scanner(System.in);

System.out.print("Enter scores of the first participants: ");
int a = sc.nextInt();

System.out.print("Enter scores of the second participants: ");
int b = sc.nextInt();

System.out.print("Enter scores of the third participants: ");
int c = sc.nextInt();

if (a > b && a > c) {
  System.out.println("The first participant's highest score is " + a);
} 

else if (b > a && b > c) {
  System.out.println("The second participant's highest score is " + b);
} 

else if (c > a && c > b) {
  System.out.println("The third participant's highest score is " + c);
} 

else
{
System.out.println("All participants scores all equal");
}

}
}
