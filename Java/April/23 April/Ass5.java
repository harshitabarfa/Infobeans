import java.util.*;

class Demo
{
public static void main(String[] args) 
{
Scanner sc = new Scanner(System.in);
int s = sc.nextInt();

int arr[] = new int[s];
for(int i = 0; i<arr.length; i++)
{
arr[i] = sc.nextInt();
}

for(int i = 0; i<s/2; i++)
{
int temp = arr[i];
arr[i] = arr[s-1-i];
arr[s-1-i] = temp;
}

for(int element : arr)
{
System.out.print(element + " ");
}

}
}
