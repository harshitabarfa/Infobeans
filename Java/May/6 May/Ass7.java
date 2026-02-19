import java.util.*;

class Ass7 
{
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

int n = sc.nextInt();
int m = sc.nextInt();

int[] a = new int[n];
int[] b = new int[m];
int[] u = new int[n+m];

int count = 0;

System.out.print("Enter elements of array a: ");
        
for (int i = 0; i < n; i++) 
{
a[i] = sc.nextInt();

int j = 0;
while (j < count) 
{
if (u[j] == a[i]) 
{
break;
}
j++;
}

if (j == count) 
{
u[count] = a[i];
count++;
}
}

System.out.print("Enter elements of array b: ");
        
for (int i = 0; i < m; i++) 
{
b[i] = sc.nextInt();

int j = 0;
while (j < count) 
{
if (u[j] == b[i]) 
{
break;
}
j++;
}

if (j == count) 
{
u[count] = b[i];
count++;
}
}

System.out.println(count);

}
}
