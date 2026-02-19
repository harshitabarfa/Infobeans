import java.util.*;

abstract class GameCharacter
{
abstract int attack();
abstract int defend();
}

class Warrior extends GameCharacter
{
int Strength;

Warrior(int Strength)
{
this.Strength = Strength; 
}

public int attack() 
{
return Strength * 3;
}

public int defend()
{
return Strength;
}
}

class Wizard extends GameCharacter
{
int magicPower;

Wizard(int magicPower)
{
this.magicPower = magicPower; 
}

public int attack() 
{
return magicPower * 2;
}

public int defend()
{
return magicPower;
}
}

class Ass1
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter choice: ");
int c = sc.nextInt();

if(c==1)
{
System.out.print("Enter strength: ");
int Strength = sc.nextInt();
Warrior w = new Warrior(Strength);

System.out.println("Warrior Actions:");

System.out.println("Attack: Powerful sword slash for " + w.attack() + " damage!");

System.out.println("Defend: Raises shield, defence boosted by " + w.defend() + "!");
}
else if(c==2)
{
System.out.print("Enter magic power: ");
int magicPower = sc.nextInt();
Wizard w1 = new Wizard(magicPower);

System.out.println("Wizard Actions:");

System.out.println("Attack: Casts spell, deals " + w1.attack() + " magical damage!");

System.out.println("Defend: Creates magical barrier, defence boosted by " + w1.defend() + "!");
}
else
{
System.out.println("Invalid choice");
}

}
}









