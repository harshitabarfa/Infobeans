import java.util.*;

class Ass3
{
public static void main(String[] args) 
{
Scanner sc = new Scanner(System.in);
System.out.print("Enter size of the array:");
int n = sc.nextInt();

System.out.println("Enter elements are: ");
if (n == 0) 
{
System.out.println(-1);
} 
else 
{
int[] arr = new int[n];

for (int i = 0; i < n; i++) 
{
arr[i] = sc.nextInt();
}

int sum = arr[n - 1];
int maxFromRight = arr[n - 1];

for (int i = n - 2; i >= 0; i--) 
{
if (arr[i] > maxFromRight) 
{
sum += arr[i];
maxFromRight = arr[i];
}
}

System.out.println("Sum: "+sum);
}

}
}

