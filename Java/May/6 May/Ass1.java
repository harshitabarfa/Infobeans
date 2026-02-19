class LibraryItem
{
String title;
String author;
int year;

public LibraryItem(String title, String author, int year)
{
this.title = title;
this.author = author;
this.year = year;
}

void display()
{
System.out.println("Title: " + title);
System.out.println("Author: " + author);
System.out.println("Year: " + year);
}
}

class Book extends LibraryItem 
{
String genre;

public Book(String title, String author, int year, String genre) 
{
super(title, author, year);
this.genre = genre;
}

void display() 
{
super.display();
System.out.println("Genre: " + genre);
}
}

class Magazine extends LibraryItem 
{
String volume;

public Magazine(String title, String author, int year, String volume) 
{
super(title, author, year);
this.volume = volume;
}

void display() 
{
super.display();
System.out.println("Volume: " + volume);
}
}

class DVD extends LibraryItem 
{
int runtime;

public DVD(String title, String author, int year, int runtime) 
{
super(title, author, year);
this.runtime = runtime;
}

void display() 
{
super.display();
System.out.println("Runtime: " + runtime + " minutes");
}
}
class Ass1
{
public static void main(String args[])
{
Book book = new Book("1984", "George Orwell", 1949, "Dystopian");

Magazine magazine = new Magazine("Time", "Various", 2023, "Vol. 58");
        
DVD dvd = new DVD("Interstellar", "Christopher Nolan", 2014, 169);

book.display();
System.out.println();
magazine.display();
System.out.println();
dvd.display();
}
}









