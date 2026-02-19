import java.util.*;

class InvalidQuantityException extends Exception 
{
    public InvalidQuantityException(String message) 
    {
        super(message);
    }
}

class Book 
{
    String id;
    String bookTitle;
    String authorName;
    float price;
    int quantity;
    
	public Book(String id, String bookTitle, String authorName, float price, int quantity) 
	{
		super();
		this.id = id;
		this.bookTitle = bookTitle;
		this.authorName = authorName;
		this.price = price;
		this.quantity = quantity;
	}
	
	public void purchase(int purchasedQty) throws InvalidQuantityException 
	{
	    if (purchasedQty > quantity) 
	    {
	        throw new InvalidQuantityException("InvalidQuantityException: Quantity not available");
	    } 
	    else 
	    {
	        quantity = quantity - purchasedQty;
	        System.out.println("Quantity Available : " + quantity);
	    }
	}
}
public class Ass1
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter id: ");
        String id = sc.nextLine();
        
        System.out.print("Enter book title: ");
        String bookTitle = sc.nextLine();
        
        System.out.print("Enter author name: ");
        String authorName = sc.nextLine();
        
        System.out.print("Enter price: ");
        float price = sc.nextFloat();
        sc.nextLine();
        
        System.out.print("Enter available quantity: ");
        int availableQty = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Enter purchased quantity: ");
        int purchasedQty = sc.nextInt();
        
        Book b = new Book(id, bookTitle, authorName, price, availableQty);

        try 
        {
            b.purchase(purchasedQty);
        } catch (InvalidQuantityException e) 
        {
            System.out.println(e.getMessage());
        }
    }
}
