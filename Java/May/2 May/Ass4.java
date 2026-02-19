import java.util.*;

class Book 
{
private String title;
private String author; 
private String isbn;

public Book(String title, String author, String isbn) 
{
this.title = title;
this.author = author;
this.isbn = isbn;
}

public void display() 
{
System.out.println("Title: " + title + ", Author: " + author + ", ISBN: " + isbn);
}
}

class Shelf 
{
private String shelfId;
private String category;
private Book[] books;

public Shelf(String shelfId, String category, int numBooks) 
{
this.shelfId = shelfId;
this.category = category;
this.books = new Book[numBooks];
}

public void addBook(int index, Book book) 
{
books[index] = book;
}

public void display() 
{
System.out.println("Shelf ID: " + shelfId + ", Category: " + category);

for (Book book : books) 
{
book.display();
}
}

public int countBooks() 
{
return books.length;
}
}

class Ass4
{
public static void main(String[] args) 
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter shelf ID: ");
String shelfId = sc.nextLine();
        
System.out.print("Enter category: ");
String category = sc.nextLine();
        
System.out.print("Enter number of books: ");
int numBooks = sc.nextInt();
sc.nextLine();

Shelf shelf = new Shelf(shelfId, category, numBooks);

for (int i = 0; i < numBooks; i++) 
{
System.out.println("Enter Book " + (i + 1) + " details:");
            
System.out.print("Title: ");
String title = sc.nextLine();
            
System.out.print("Author: ");
String author = sc.nextLine();
            
System.out.print("ISBN: ");
String isbn = sc.nextLine();
            
shelf.addBook(i, new Book(title, author, isbn));
}

shelf.display();

System.out.println("Total number of books: " + shelf.countBooks());

}
}
