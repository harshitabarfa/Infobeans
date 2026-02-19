import java.util.Scanner;

class Ass7
{

public static void main(String[] args) 
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter rows: ");
int row = sc.nextInt();

System.out.print("Enter columns: ");
int col = sc.nextInt();

int[][] arr1 = new int[row][col];
int[][] arr2 = new int[row][col];
int[][] sum = new int[row][col];

System.out.println("Enter elements of first array:");
for (int i = 0; i < row; i++) 
{
for (int j = 0; j < col; j++) 
{
arr1[i][j] = sc.nextInt();
}
}

System.out.println("Enter elements of second array:");
for (int i = 0; i < row; i++) 
{
for (int j = 0; j < col; j++) 
{
arr2[i][j] = sc.nextInt();
}
}

for (int i = 0; i < row; i++) 
{
for (int j = 0; j < col; j++) 
{
sum[i][j] = arr1[i][j] + arr2[i][j];
}
}

System.out.println("Sum of the two arrays:");
for (int i = 0; i < row; i++) 
{
for (int j = 0; j < col; j++) 
{
System.out.print(sum[i][j] + " ");
}
System.out.println();
}

}
}
