import java.util.*;

class Ass1
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Total event duration in seconds: ");
int a = sc.nextInt();

int b = (a/60)/60;
int c = (a/60)%60;
int d = a%60;

System.out.print("Hours: " +b+ ", Minutes: " +c+ ", Seconds: "+d);
}
}