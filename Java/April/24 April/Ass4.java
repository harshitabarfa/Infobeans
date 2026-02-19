import java.util.*;

class Ass4
{
public static void main(String[] args) 
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter size of array: ");
int n = sc.nextInt();
int[] arr = new int[n];

System.out.print("Enter elements: ");
for (int i = 0; i < n; i++) 
{
arr[i] = sc.nextInt();
}

int sum = 0;

System.out.print("Sum is: ");
for (int i = 0; i < n; i++) 
{
int count = 0;

for (int j = 0; j < n; j++) 
{
if (arr[i] == arr[j]) 
{
count++;
}
}

if (count == 1) 
{
sum += arr[i];
}
}

System.out.println(sum);

}
}
