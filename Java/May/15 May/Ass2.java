import java.util.*;

abstract class MatrixOperation
{
abstract int[][] performOperation(int[][] m1, int[][] m2);
}

class MatrixAddition extends MatrixOperation
{
public int[][] performOperation(int[][] m1, int[][] m2)
{
int n = m1.length;
int[][] result = new int[n][n];

for(int i = 0; i<n; i++)
{
for(int j = 0; j<n; j++)
{
result[i][j] = m1[i][j] + m2[i][j];
}
}
return result;
}
}

public class Ass2
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Number of rows and columns: ");
int n = sc.nextInt();

int[][] m1 = new int[n][n];
int[][] m2 = new int[n][n];

for (int i = 0; i < n; i++)
{
for (int j = 0; j < n; j++)
{
m1[i][j] = sc.nextInt();
}
}

for (int i = 0; i < n; i++)
{
for (int j = 0; j < n; j++)
{
m2[i][j] = sc.nextInt();
}
}

MatrixOperation o = new MatrixAddition();

int[][] result = o.performOperation(m1, m2);

System.out.println("Addition of the given matrices: ");

for (int i = 0; i < n; i++) 
{
for (int j = 0; j < n; j++) 
{
System.out.print(result[i][j] + " ");
}
System.out.println();
}

}
}



















