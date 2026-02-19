import java.util.*;

class Arr3
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

int n = sc.nextInt();

if(n<1 || n>1000)
{
System.out.println("Error: Array size must be between 1 to 1000");
return;
}

int arr[] = new int[n];

for(int i = 0; i<arr.length; i++)
{
arr[i] = sc.nextInt();
}

int sum = 0;
for(int num : arr)
{
sum+=num;
}

int leftSum = 0;
for(int i = 0; i<n; i++)
{
int rightSum = sum-leftSum -arr[i];
if(leftSum==rightSum)
{
System.out.println(i);
return;
}
leftSum += arr[i];
}
System.out.println(-1);
}
}
