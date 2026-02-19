import java.util.*;

class Book
{
String title;
private String author;
String genre;
boolean isAvailable;

public String getAuthor() 
{
return author;
}

public Book(String title, String author, String genre, boolean isAvailable)
{
this.title = title;
this.author = author;
this.genre = genre;
this.isAvailable = isAvailable;
}

public void display()
{
System.out.println("Title: " +title);
System.out.println("Author: " +author);
System.out.println("Genre: " +genre);
System.out.println("Book is available or not: " + (isAvailable ? "Yes" : "No"));
}

}
class Ass2
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter number of books: ");
int n = sc.nextInt();
sc.nextLine();

Book b1[] = new Book[n];

for(int i = 0; i<n; i++)
{
System.out.println();
System.out.println("Enter details for "+ (i+1) + " book:");

System.out.print("Enter title name: ");
String title = sc.nextLine();

System.out.print("Enter author name: ");
String author = sc.nextLine();

System.out.print("Enter genre: ");
String genre = sc.nextLine();

System.out.print("Available (true/false): ");
boolean isAvailable = sc.nextBoolean();
sc.nextLine();

b1[i] = new Book(title, author, genre, isAvailable);

}

while (true) 
{
System.out.println();
System.out.println("Menu:");

System.out.println("1. Display all books");
System.out.println("2. Display books of a specific genre");
System.out.println("3. Display available books");
System.out.println("4. Display books by a specific author");
System.out.println("5. Exit");

System.out.println();

System.out.print("Enter your choice: ");

int choice = sc.nextInt();
sc.nextLine(); 

switch (choice) 
{
case 1:
System.out.println("All books:");
for (Book b : b1) 
{
System.out.println();
b.display();
}
break;

case 2:
System.out.print("Enter the genre: ");
String genre = sc.nextLine();

System.out.println();          System.out.println("Books of genre " + genre + ":");
boolean foundGenre = false;

for (Book b : b1) 
{
if (b.genre.equalsIgnoreCase(genre)) 
{
b.display();
foundGenre = true;
}
}
if (!foundGenre) 
{
System.out.println("No books found for genre: " + genre);
}
break;

case 3:              System.out.println("Available Books:");
boolean foundAvailable = false;

for (Book b : b1)
{
if (b.isAvailable) 
{
b.display();                           foundAvailable = true;
}
}
if (!foundAvailable) 
{                       
System.out.println("No available books.");
}
break;

case 4:                      System.out.print("Enter the author's name: ");
String author = sc.nextLine();
                    System.out.println("Books by " + author + ":");

boolean foundAuthor = false;
for (Book b : b1)
{
if(b.getAuthor().equalsIgnoreCase(author))
{                            
b.display();
foundAuthor = true;
}
}
if (!foundAuthor) 
{                        
System.out.println("No books found by author: " + author);
}
break;

case 5:                   System.out.println("Exiting...!!");
return;

default:                   System.out.println("Invalid choice. Please try again.");
}
System.out.println();
}

}
}







