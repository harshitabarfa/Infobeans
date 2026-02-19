class Animal 
{
void sound() 
{
System.out.println("Animals make sound");
}
}

class Dog extends Animal 
{
void sound() 
{
super.sound();
System.out.println("Dogs bark");
}
}

class Ass4 
{
public static void main(String[] args) 
{
Dog dog = new Dog();
dog.sound();
}
}


