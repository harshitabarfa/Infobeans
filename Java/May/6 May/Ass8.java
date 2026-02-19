import java.util.*;

class Ass8
{
public static void main(String[] args) 
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter array size: ");
int n = sc.nextInt();

int[] arr = new int[n];
        
System.out.println("Enter array elements:");
for (int i = 0; i < n; i++) 
{
arr[i] = sc.nextInt();
}

int last = arr[n - 1];

for (int i = n - 1; i > 0; i--) 
{
arr[i] = arr[i - 1];        
}
arr[0] = last;

System.out.println("Array rotation:");

for (int i = 0; i < n; i++) 
{
System.out.print(arr[i] + " ");
}
System.out.println();
}
}
