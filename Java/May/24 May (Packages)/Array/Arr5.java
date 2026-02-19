import java.util.*;

class Arr5
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

int n = sc.nextInt();
int k = sc.nextInt();

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

k = k%n;
reverse(arr, 0, n-1);
reverse(arr, 0, k-1);
reverse(arr, k, n-1);

for(int i = 0; i<n; i++)
{
System.out.print(arr[i] + " ");
}
}

public static void reverse(int[] arr, int start, int end) 
{
while (start < end) 
{
int temp = arr[start];
arr[start] = arr[end];
arr[end] = temp;

start++;
end--;
}

}
}
