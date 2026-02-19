import java.util.*;

class Ass5
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter minimum steps: ");
int minNum = sc.nextInt();

System.out.print("Enter maximum steps: ");
int maxNum = sc.nextInt();

for(int n=minNum; n<=maxNum; n++)
{
  int sum = 0;
  int i=1;
  while(i<=n/2)
  {
  if(n%i==0)
  {
  sum+=i;
  }
  i++;
  }
  if(sum==n && n!=0){
  System.out.println("Day with " + n + " steps is a Perfect Day!");

}
}}}