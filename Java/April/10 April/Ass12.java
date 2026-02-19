import java.util.*;

class Ass12
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter length: ");
int length = sc.nextInt();

System.out.print("Enter breadth: ");
int breadth = sc.nextInt();

int area = length * breadth;

System.out.println("Number of tiles needed: "+area);

System.out.println("Enter tiles size: ");
int size = sc.nextInt();

int tiles = size*size;
System.out.println(tiles);

int d = area/tiles;
System.out.println(d);
}
}