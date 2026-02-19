import java.util.*;

class Ass6
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter row: ");
int row = sc.nextInt();

System.out.print("Enter column: ");
int col = sc.nextInt();

int a[][] = new int[row][col];

System.out.println("Enter elements: ");
for(int i = 0; i<row; i++)
{
for(int j = 0; j<col; j++)
{
a[i][j] = sc.nextInt();
}
}

System.out.println("Elements are: ");
int max = a[0][0];
for(int i = 0; i<row; i++)
{
for(int j = 0; j<col; j++)
{
if(a[i][j]>max)
{
max = a[i][j];
}
}
}
System.out.println(max);


/* int min = a[0][0];
for(int i = 0; i<row; i++)
{
for(int j = 0; j<col; j++)
{
if(a[i][j]<min)
{
min = a[i][j];
}
}
}
System.out.println(min); */

}
}