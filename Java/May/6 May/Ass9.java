import java.util.*;

class Ass9
{
public static void main(String[] args) 
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter array size: ");
int n = sc.nextInt();

System.out.print("Enter key element: ");
int k = sc.nextInt();

int[] arr = new int[n];

System.out.println("Enter array elements:");
for(int i = 0; i < n; i++)
{
arr[i] = sc.nextInt();
}

int count = 0;
for(int i = 0; i < n; i++) 
{
for(int j = i+1; j < n; j++) 
{
if(arr[i] + arr[j] == k) 
{
System.out.println("( "+arr[i]+","+arr[j]+" )");
count++;
}
}
}

System.out.println(count);
}
}