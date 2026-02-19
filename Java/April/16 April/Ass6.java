import java.util.*;

class Ass6 {
public static void main(String[] args) 
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter number: ");
int num = sc.nextInt();

int n = num;
int result = 0;

/* while (num != 0) 
{
int digit = num % 10;
result += digit * digit * digit;
num /= 10;
} */

/* do{
int digit = num % 10;
result += digit * digit * digit;
num /= 10;
}
while (num != 0); */

for(; num>0; num=num/10)
{
int digit = num % 10;
result = result + digit * digit * digit;
}

if (result == n) 
{
System.out.println(n + " is an Armstrong number");
} 
else 
{
System.out.println(n + " is not an Armstrong number");
}

}
}
