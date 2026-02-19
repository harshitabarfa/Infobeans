import java.util.*;

class Ass6 
{
public static void main(String[] args) 
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter rows: ");
int r = sc.nextInt();

System.out.print("Enter columns: ");
int c = sc.nextInt();

int[][] scores = new int[r][c];

System.out.println("Enter scores:");
for (int i = 0; i < r; i++) 
{
for (int j = 0; j < c; j++) 
{
scores[i][j] = sc.nextInt();
}
}

int count = 0;

System.out.println("Perfect numbers are:");
for (int i = 0; i < r; i++) 
{
for (int j = 0; j < c; j++) 
{
int num = scores[i][j];
int sum = 0;

for (int k = 1; k < num; k++) 
{
if (num % k == 0) 
{
sum += k;
}
}

if (sum == num && num != 0) 
{
System.out.println("Perfect number: " + num);
count++;
}
}
}

System.out.println("Total perfect numbers are: " + count);

}
}
