import java.util.*;

class Ass5 
{

public static void main(String[] args) 
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter rows: ");
int r = sc.nextInt();

System.out.print("Enter columns: ");
int c = sc.nextInt();

int[][] arr = new int[r][c];

System.out.println("Enter the elements: ");

for (int i = 0; i < r; i++) 
{
for (int j = 0; j < c; j++) 
{
arr[i][j] = sc.nextInt();
}
}

int count1 = 0;

for (int i = 0; i < r; i++) 
{
for (int j = 0; j < c; j++) 
{
int num = arr[i][j];

if (num <= 1) 
continue;

int count2 = 0;

for (int k = 1; k <= num; k++) 
{
if (num % k == 0) 
{
count2++;
}
}

if (count2 == 2) 
{
count1++;
}
}
}

System.out.println("Total prime numbers in the array: " + count1);

}
}
