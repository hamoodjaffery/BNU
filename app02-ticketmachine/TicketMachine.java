/**
 * TicketMachine to issue the tickets of fixed price.
 * The price of each ticket is set out using the constructor.
 * Testing will check to ensure that if a person enters more money than
 * the ticket price or less than the ticket price, so the ticket machine has
 * to work accordingly indicating less amount or more amount,
 * if enough money has been inserted.
 * @Date 18.10.2020
 * 
 * Modified by Hamood Jaffery
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    
    // The amount of money entered by a customer so far.
    private int balance;
    
    // The total amount of money collected by this machine.
    private int total;
    
    // The current balance of a customer
    private int currentBalance;
    
    private Ticket aylesburyTicket;
    
    private Ticket highwycombeTicket;
    
    private Ticket amershamTicket;
    
    private Ticket selectedTicket;
      
    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine()
    {
        balance = 0;
        total = 0;
        
        aylesburyTicket = new Ticket("Aylesbury", 220);
        
        highwycombeTicket = new Ticket("High Wycombe", 330);
        
        amershamTicket = new Ticket("Amersham", 300);
        
        selectedTicket = null;
    }
    
    public void selectAylesbury()
    {
       
       selectedTicket = aylesburyTicket;
       
       selectedTicket = highwycombeTicket;
       
       selectedTicket = amershamTicket;
        
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }
    
    public double getCurrentBalance()
    {
        return currentBalance;
    }
        
    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) 
        {
            balance = balance + amount;
        }
        else 
        {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
    }
   public void insert20p()
    {
        balance = balance + 20;
    }
    
    public void insert100p()
    {
        balance = balance + 100;
    }
    
    public void insert200p()
    {
        balance = balance + 200;
    }
     
    public void insert10p()
    {
       balance = balance + 10;
    }
    
    
    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(balance >= price) 
        {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the price.
            balance = balance - price;
        }
        else 
        {
            System.out.println("You must insert at least: " +
                               (price - balance) + " more cents.");
                    
        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
}
