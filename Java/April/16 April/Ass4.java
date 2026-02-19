
import java.util.*;

class Ass4
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter a number: ");
int n = sc.nextInt();

int rev = 0;

// While loop:
// while(n>0)
// {
// rev = rev*10+n%10;
// n=n/10;
// }
// System.out.println(rev);


// Do-while loop:
/* do{
rev = rev*10+n%10;
n=n/10;
}
while(n>0);
System.out.println(rev);
} */

// For loop:
for(; n>0; n = n/10)
{
rev = rev*10+n%10;
}
System.out.println(rev);

}
}



