import java.util.Date;

/**
 * Write a description of class Ticket here.
 *
 * @author Hamood Jaffery
 * @version (a version number or a date)
 */
public class Ticket
{
    private String destination;
    
    // this is in pence
    private int price;
    
    private Date datePurchased = new Date();
    
    /**
     * Constructor for objects of class Ticket
     * Just creates an Aylesbury Ticket
     */
    public Ticket()
    {
        price = 220;
        destination = "Aylesbury";
        datePurchased = new Date();
    }
    
    /**
     * Creates a new ticket with a given destination
     * and price
     */
    public Ticket(String destination, int price)
    {
        this.price = price;
        this.destination = destination;
    }
    
    public void setPrice(int price)
    {
        this.price = price;
    }
    
    public void print()
    {
        System.out.println("Destination:" + destination);
        System.out.println (price + "pence");
    }
}
    