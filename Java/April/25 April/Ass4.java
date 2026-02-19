import java.util.*;

public class Ass4 
{

public static void main(String[] args) 
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter number of students: ");
int s = sc.nextInt();

System.out.print("Enter number of tests: ");
int t = sc.nextInt();

int[][] scores = new int[s][t];

System.out.println("Enter the test scores:");
for (int i = 0; i < s; i++) 
{
for (int j = 0; j < t; j++) 
{
System.out.print("Score for Student " + (i + 1) + ", Test " + (j + 1) + ": ");
scores[i][j] = sc.nextInt();
}
}

int evenSum = 0;
int oddSum = 0;

for (int i = 0; i < s; i++) 
{
for (int j = 0; j < t; j++) 
{
if (scores[i][j] % 2 == 0) 
{
evenSum += scores[i][j];
} 
else 
{
oddSum += scores[i][j];
}
}
}

System.out.println("Sum of all even test scores: " + evenSum);

System.out.println("Sum of all odd test scores: " + oddSum);

}
}
