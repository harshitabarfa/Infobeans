import java.util.*;

class Delivery
{
private long over;
private long ball;
private long runs;
private String batsman;
private String bowler;
private String nonStriker;

public Delivery(long over, long ball, long runs, String batsman, String bowler, String nonStriker)
{
this.over = over;
this.ball = ball;
this.runs = runs;
this.batsman = batsman;
this.bowler = bowler;
this.nonStriker = nonStriker;
}

public long getOver()
{
return over;
}

public long getBall()
{
return ball;
}

public long getRuns()
{
return runs;
}

public String getBatsman()
{
return batsman;
}

public String getBowler()
{
return bowler;
}

public String getNonStriker()
{
return nonStriker;
}

/* public void display()
{
System.out.println("Over: " +over);
System.out.println("Ball: " +ball);
System.out.println("Runs: " +runs);
System.out.println("Batsman: " +batsman);
System.out.println("Bowletr: " +bowler);
System.out.println("Non Striker: " +nonStriker);
} */

}

class Ass1
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter size: ");
int size = sc.nextInt();
sc.nextLine();

System.out.println();
Delivery d1[] = new Delivery[size];

for(int i = 0; i<size; i++)
{
System.out.println("Enter details for delivery " +(i+1) + ":");

System.out.print("Over: ");
long over = sc.nextLong();
sc.nextLine();

System.out.print("Ball: ");
long ball = sc.nextLong();
sc.nextLine();

System.out.print("Runs: ");
long runs = sc.nextLong();
sc.nextLine();

System.out.print("Batsman: ");
String batsman = sc.nextLine();

System.out.print("Bowler: ");
String bowler = sc.nextLine();

System.out.print("NonStriker: ");
String nonStriker = sc.nextLine();

d1[i] = new Delivery(over, ball, runs, batsman, bowler, nonStriker);

System.out.println();
} 

System.out.println();
System.out.println("Delivery details:");

for(Delivery d : d1)
{
System.out.println("Over: " +d.getOver());
System.out.println("Ball: " +d.getBall());
System.out.println("Runs: " +d.getRuns());
System.out.println("Batsman: " +d.getBatsman());
System.out.println("Bowletr: " +d.getBowler());
System.out.println("Non Striker: " +d.getNonStriker());

System.out.println();
} 

// d1.display();
}
}