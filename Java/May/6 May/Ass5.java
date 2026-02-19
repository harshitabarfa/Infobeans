import java.util.*;

class Ass5
{
public static void main(String[] args) 
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter size: ");
int n = sc.nextInt();

System.out.print("Enter elements: ");
int[] arr = new int[n];
for (int i = 0; i < n; i++) 
{
arr[i] = sc.nextInt();
}

if (n == 1 || arr[0] >= arr[1]) 
{
System.out.println(1);
}

else if (arr[n - 1] >= arr[n - 2]) 
{
System.out.println(1);
}

else
{
for (int i = 1; i < n - 1; i++) 
{
if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1]) {
System.out.println(0);
break;
}
}
}

}
}
