import java.util.*;

class Member
{
protected int hours;

Member(int hours)
{
this.hours = hours;
}

public int calculateRewardsPoints()
{
return hours*2;
}
}

class PremiumMember extends Member
{
PremiumMember(int hours)
{
super(hours);
}

public int calculateRewardsPoints()
{
return hours*4;
}
}

class Ass3
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
System.out.print("Enter hours: ");
int hours = sc.nextInt();
sc.nextLine();

System.out.print("Member is premium or not: ");
String s = sc.nextLine();


Member m;
if (s.equalsIgnoreCase("yes")) 
{
m = new PremiumMember(hours);
System.out.println("Rewards point for premium member: " + m.calculateRewardsPoints());

} 
else 
{
m = new Member(hours);
System.out.println("Rewards point for regular member: " + m.calculateRewardsPoints());
}

}
}
















