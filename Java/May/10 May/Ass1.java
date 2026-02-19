import java.util.*;

class Ass1
{
public static int pairs(int[] arr, int n, int k)
{
int count = 0;
for (int i = 0; i < n; i++) 
{
for (int j = i + 1; j < n; j++) 
{
if (arr[i] + arr[j] == k) 
{
count++;
}
}
}
return count;
}

public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

int n1 = sc.nextInt();

for(int i = 0; i<n1; i++)
{
int size = sc.nextInt();
int[] arr1 = new Int[size];

for(int j = 0; j<size; j++)
{
arr1[j] = sc.nextInt();
}
int k1 = sc.nextInt();
System.out.println(pairs(arr1, arr1.length, k1));
}

}
}