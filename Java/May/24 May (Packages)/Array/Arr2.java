import java.util.*;

class Arr2
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

int n = sc.nextInt();
int k = sc.nextInt();

if(n<1 || n>100 || k < -1000 || k >1000)
{
System.out.println("Error: Input out of allowed constraints");
return;
}

int arr[] = new int[n];

for(int i = 0; i<arr.length; i++)
{
arr[i] = sc.nextInt();
}

int count = 0;

for(int i = 0; i<n; i++)
{
int sum = 0;
for(int j = i; j<n; j++)
{
sum += arr[j];
if(sum==k)
{
count++;
}
}
}
System.out.println(count);
}
}
