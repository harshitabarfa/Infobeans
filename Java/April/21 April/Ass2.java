import java.util.*;

class Ass2
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter a character: ");
char ch = sc.next().charAt(0);

switch(ch)
{
case 'A':
System.out.println("Excellent");
break;

case 'B':
System.out.println("Very Good");
break;

case 'C':
System.out.println("Good");
break;

case 'D':
System.out.println("Satisfactory");
break;

case 'F':
System.out.println("Fail");
break;

default:
System.out.print("Invalid grade");
}
}}
