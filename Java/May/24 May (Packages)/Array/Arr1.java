import java.util.*;

class Arr1
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

int n = sc.nextInt();

if(n<1 || n>100)
{
System.out.println("Error: array size should be between 1 to 100");
return;
}

int arr[] = new int[n];

for(int i = 0; i<arr.length; i++)
{
arr[i] = sc.nextInt();
}

Arrays.sort(arr);

int smallPos = 1;

for(int i = 0; i<n; i++)
{
if(arr[i] == smallPos)
{
smallPos++;
}
}
System.out.println(smallPos);
}
}
