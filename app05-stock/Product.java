/**
 * Details of products sold by Jaffery's Telecommunication
 * Modified by Hamood Jaffery
 * 04.Nov.2020
 */
public class Product
{
    // An identifying number for this product.
    private int id;
    // The name of this product.
    private String name;
    // The quantity of this product in stock.
    private int quantity;

    /**
     * Constructor for objects of class Product.
     * The initial stock quantity is zero.
     * @param id The product's identifying number.
     * @param name The product's name.
     */
    public Product(int id, String name)
    {
        this.id = id;
        this.name = name;
        quantity = 0;
    }

    /**
     * @return product's id.
     */
    public int getID()
    {
        return id;
    }

    /**
     *return The product's name.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     *set The product's name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return The quantity in stock.
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * @return The id, name and quantity in stock.
     */
    public String toString()
    {
        return id + ": " +  name + " stock level: " + quantity;
    }

    /**
     * Restock with the given amount of this product.
     * The current quantity is incremented by the given amount.
     * @param amount The number of new items added to the stock.
     *               This must be greater than zero.
     */
    public void deliver(int amount)
    {
        if(amount > 0) 
        {
            quantity = quantity + amount;
        }
        else 
        {
            System.out.println("Can not restock " + name +
                               " invalid amount entered!: " + amount);
        }
    }

    /**
     * Sell one of these products.
     * An error is reported if there appears to be no stock.
     */
    public void sell(int saleQuantity)
    {
      if(saleQuantity > -0) 
        {
            System.out.println("Only " + quantity + " " + name +
                " in stock, but there were " +
                saleQuantity + " ordered ");

            quantity = 0;
        }
        else 
        {
           System.out.println(
                "Can not sell " + saleQuantity + " invalid quantity entered: " + name);
                quantity -= saleQuantity;
        }
        
     
    }
}
