import java.util.*;

class Book
{
private String title;
private String author;
private double price;
private int quantity;

public String getTitle()
{
return title;
}

public String getAuthor()
{
return author;
}

public double getPrice()
{
return price;
}

public int getQuantity()
{
return quantity;
}

public Book(String title, String author, double price, int quantity)
{
this.title = title;
this.author = author;
this.price = price;
this.quantity = quantity;
}

/* public void displayDetails()
{
System.out.println("Title: " +title);
System.out.println("Author: " +author);
System.out.println("Price: " +price);
System.out.println("Quantity: " +quantity);
} */

}
class Ass2
{
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);

System.out.print("Enter size: ");
int size = sc.nextInt();
sc.nextLine();

System.out.println();
Book b[] = new Book[size];

for(int i = 0; i<size; i++)
{
System.out.println("Enter details for book " +(i+1) + ":");

System.out.print("Title: ");
String title = sc.nextLine();

System.out.print("Author: ");
String author = sc.nextLine();

System.out.print("Price: ");
double price = Double.parseDouble(sc.nextLine());

System.out.print("Quantity: ");
int quantity = Integer.parseInt(sc.nextLine());

b[i] = new Book(title, author, price, quantity);

System.out.println();
}


System.out.println("Display book details: ");
for(Book x : b)
{
System.out.println("Title: " + x.getTitle());
System.out.println("Author: " + x.getAuthor());
System.out.println("Price: " + x.getPrice());
System.out.println("Quantity: " + x.getQuantity());

System.out.println();
}

/* Book b1 = new Book("Atomic Habit", "James clear", 145, 2);

Book b2 = new Book("Malgudi Days", "R.K Narayan", 175, 5);

Book b3 = new Book("Midnight's Children", "Salman Rushdie", 133, 3); */

/* System.out.println("Book 1 Details:");
b1.displayDetails();
System.out.println();

System.out.println("Book 2 Details:");
b2.displayDetails();
System.out.println();

System.out.println("Book 3 Details:");
b3.displayDetails(); */
}
}