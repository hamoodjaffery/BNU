/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class StockDemo
{
    // The stock manager.
    private StockManager manager;

    /**
     * Create a StockManager and populate it with a few
     * sample products.
     */
    public StockDemo(StockManager manager)
    {
        this.manager = manager;
        
        manager.addProduct(new Product(100, "Apple iPhone 11 Pro Max (128GB)"));
        manager.addProduct(new Product(101, "Apple iPhone 11 (64GB)"));
        manager.addProduct(new Product(102, "Apple iPhone X (128GB)"));
        manager.addProduct(new Product(103, "Apple iPhone XR (64GB)"));
        manager.addProduct(new Product(104, "Apple iPhone XS Max (256GB)"));
        manager.addProduct(new Product(105, "Apple iPhone 12 (128GB)"));
        manager.addProduct(new Product(106, "Apple iPhone 12 Pro (256GB)"));
        manager.addProduct(new Product(107, "Sony Xperia XA2 Ultra (16GB)"));
        manager.addProduct(new Product(108, "Sony Xperia XA2 Compact (8GB)"));
        manager.addProduct(new Product(109, "Sony Xperia XA2 (16GB)"));
        manager.addProduct(new Product(110, "Samsung Note 20 Ultra 5G (256GB)"));
        manager.addProduct(new Product(111, "Samsung Note 20 (128GB)"));
    }
    
    /**
     * Provide a very simple demonstration of how a StockManager
     * might be used. Details of one product are shown, the
     * product is restocked, and then the details are shown again.
     */
    public void demo()
    {
        // Show details of all of the products.
        manager.printAllProducts();
        // Take delivery of 5 items of one of the products.
        manager.delivery(132, 5);
        manager.printAllProducts();
    }
    
    /**
     * Show details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void showDetails(int id)
    {
        Product product = getProduct(id);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Sell one of the given item.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int id)
    {
        Product product = getProduct(id);
        
        if(product != null) 
        {
            showDetails(id);
            product.sell(5);
            showDetails(id);
        }
    }
    
    /**
     * Get the product with the given id from the manager.
     * An error message is printed if there is no match.
     * @param id The ID of the product.
     * @return The Product, or null if no matching one is found.
     */
    public Product getProduct(int id)
    {
        Product product = manager.findProduct(id);
        
        if(product == null) 
        {
            System.out.println("Product with ID: " + id +
                               " is not recognised.");
        }
        return product;
    }

    /**
     * @return The stock manager.
     */
    public StockManager getManager()
    {
        return manager;
    }
}
