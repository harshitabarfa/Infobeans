class Book
{
String title;
String author;
double price;

public Book(String title, String author,
double price)
{
this.title = title;
this.author = author;
this.price = price;
}

public Book(Book x)
{
this.title = x.title;
this.author = x.author;
this.price = x.price;
}

public void display()
{
System.out.println("Title: "+title);
System.out.println("Author: "+author);
System.out.println("Price: "+price);
System.out.println();
}

}
class Ass4
{
public static void main(String args[])
{
Book b1 = new Book("Atomic habit", "James clear", 230);
b1.display();

Book b2 = new Book(b1);
b2.display();
}
}







