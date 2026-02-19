import java.util.*;

class Ass2
{
public static void main(String[] args) 
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter a number: ");
int n = sc.nextInt();

for (int i = 1; i <= n; i++) 
{
int sq = i*i;
int cb = i*i*i;
double sqrt = Math.sqrt(i);

System.out.println(i + "\t" + sq + "\t" + cb + "\t" + sqrt);
}
}
}