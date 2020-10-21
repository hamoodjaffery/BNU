import java.util.Date;
/**
 * Destination of the ticket is defined. Ticket should show the selected destination,
 * its price, and date time stamp as well.
 *
 * @author Hamood Jaffery
 * @date 18.10.2020
 */
public class Ticket
{
    // Ticket Destination
    private String destination;
    
    // this is ticket price in pence
    private int price;
    
    // The date and timestamp of the ticket issuance
    private Date timeStamp;
    
    /**
     * Constructor for objects of class Ticket
     * 
     */
    public Ticket(String destination, int price)
    {
        timeStamp = new Date();
        this.destination = destination;
        this.price = price;
    }
                
    /**
     * Return the ticket's destination as a string
     * NOT NEEDED
     */
    public String getDestination()
    {
        return destination;
    }
    
    public int getPrice()
    {
        return price;
    }
    
    /**
     * prints the ticket
     */    
    public void print()
    {
        System.out.println("Ticekt to " + destination);
        System.out.println("cost " + price + "p");
        System.out.println("Issued: " + timeStamp);
    }
}
     
