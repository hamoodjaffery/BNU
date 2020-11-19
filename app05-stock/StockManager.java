import java.util.ArrayList;
/**
 * Stock Manager manages stock of Jaffery's Telecommunication.
 * Modified by Hamood Jaffery
 * 04.Nov.2020
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * 
     */
    public void addProduct(Product item)
    {
        stock.add(item);
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
       Product product = findProduct(id);
        
       if(product != null)
       {
            product.deliver(amount);
       }
       else
       {
            System.out.println("\nCannot find product id " + id + "\n");
       }
    }
    
    /**
     * Sell the Product.
     */
    public void sellProduct(int id, int quantity)
    {
        Product product = findProduct(id);
        
        if(product != null)
        {
            product.sell(quantity);
        }
    }
    
    /**
     * Rename the product.
     */
    public void renameProduct(int id, String name)
    {
        Product product = findProduct(id);
        
        if(product != null)
        {
            product.setName(name);
        }
    }
    
    /**
     * Remove the product.
     */
    public void removeProduct(int id)
    {
        Product product = findProduct(id);
        
        if(product != null)
        {
            stock.remove(product);
        }
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *      with a matching ID.
     */
    public Product findProduct(int id)
    {
        for(Product product : stock)
        {
            if(product.getID() == id)
            {
                return product;
            }
        }
        return null;
    }
    
    /**
     * Indicate if there is a duplicate id
     */
    public boolean isDuplicate(int id)
    {
        Product product = findProduct(id);
        
        if(product == null)
            return false;
        else
            return true;
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberProductsInStock()
    {
        return stock.size();
    }
    
    /**
     * Show details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void printDetails(int id)
    {
        Product product = findProduct(id);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }    

    /**
     * Print details of all the products.
     */
    public void printAllProducts()
    {
        printHeading();
        
        for(Product product : stock)
        {
            //product.print();
            System.out.println(product);
        }
        
    }
    
    public void printPrintProductByName(String partOfName) 
    {
        printHeading();
        System.out.println("Printing Products By Name: " + partOfName);
        for (Product product: stock) 
        {
            if (product.getName().contains(partOfName)) 
            {
                System.out.println(product);
            }
        }
    }
    
    public void printPrintLowStock(int stockLevel)
    {
       printHeading();
        System.out.println("Printing low stock products" + stockLevel);
        for (Product product: stock) 
        {
            if (product.getQuantity() < stockLevel) 
            {
                System.out.println(product);
            }
        }
    }
    
    public void printHeading()
    {
    System.out.println("===========================");
    System.out.println("Jaffery's Telecommunication");
    System.out.println("===========================");
    System.out.println("Jaffery's Telecommunication Stock List");
    System.out.println(" ");
    }
   
}
