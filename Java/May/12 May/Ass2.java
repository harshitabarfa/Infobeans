class Animal
{
public void makeSound()
{
System.out.println("Some generic sound.");
}
}

class Dog extends Animal
{
public void makeSound()
{
System.out.println("Woof Woof");
}
}

class Cat extends Animal
{
public void makeSound()
{
System.out.println("Meow Meow");
}
}

class Ass2
{
public static void main(String args[])
{
Animal a[] = new Animal[3];

a[0] = new Animal();
a[1] = new Dog();
a[2] = new Cat();

for (Animal a1 : a)
{
a1.makeSound();
}

}
}

