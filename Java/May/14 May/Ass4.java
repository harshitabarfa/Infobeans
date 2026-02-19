abstract class LibraryItem 
{
String title;
String author;

LibraryItem(String title, String author) {
this.title = title;
this.author = author;
}

abstract void checkout();
abstract void returnItem();

void displayInfo() 
{
System.out.println("Title: " + title);
System.out.println("Author: " + author);
}
}

class Book extends LibraryItem 
{
int pages;

Book(String title, String author, int pages) 
{
super(title, author);
this.pages = pages;
}

void checkout() 
{
System.out.println("Checking out book: " + title);
}

void returnItem() 
{
System.out.println("Returning book: " + title);
}
}

class DVD extends LibraryItem 
{
int duration;

DVD(String title, String author, int duration) 
{
super(title, author);
this.duration = duration;
}

void checkout() 
{
System.out.println("Checking out DVD: " + title);
}

void returnItem() 
{
System.out.println("Returning DVD: " + title);
}
}

public class Ass4 
{
public static void main(String[] args) 
{
Book book = new Book("The Alchemist", "Paulo Coelho", 208);

DVD dvd = new DVD("Inception", "Christopher Nolan", 148);

book.checkout();
book.displayInfo();
book.returnItem();

System.out.println();

dvd.checkout();
dvd.displayInfo();
dvd.returnItem();
}
}