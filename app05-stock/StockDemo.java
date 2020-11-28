import java.util.Random;
/**
 * Stock Demo class is for testing purpose only.
 * Modified by Hamood Jaffery
 * 04.Nov.2020
 */
public class StockDemo
{
    // The stock manager.
    private StockManager manager;

    private Random generator = new Random();

    private int amount = 0;
     

    /**
     * Create a StockManager and populate it with a few
     * sample products.
     */
    public StockDemo(StockManager manager)
    {
        this.manager = manager;

        manager.addProduct(new Product(101, "Apple iPhone 11 Pro Max (128GB)"));
        manager.addProduct(new Product(102, "Apple iPhone 11 (64GB)"));
        manager.addProduct(new Product(103, "Apple iPhone X (128GB)"));
        manager.addProduct(new Product(104, "Apple iPhone XR (64GB)"));
        manager.addProduct(new Product(105, "Apple iPhone XS Max (256GB)"));
        manager.addProduct(new Product(106, "Apple iPhone 12 (128GB)"));
        manager.addProduct(new Product(107, "Apple iPhone 12 Pro (256GB)"));
        manager.addProduct(new Product(108, "Sony Xperia XA2 Ultra (16GB)"));
        manager.addProduct(new Product(109, "Sony Xperia XA2 Compact (8GB)"));
        manager.addProduct(new Product(110, "Sony Xperia XA2 (16GB)")); 
    }

    /**
     * Provide a very simple demonstration of how a StockManager
     * might be used. Details of one product are shown, the
     * product is restocked, and then the details are shown again.
     */
    public void runDemo()
    {
        manager.printAllProducts();

        int noProducts = manager.numberProductsInStock();

        System.out.println("No of Products in Stock = " + noProducts);

        demoDeliverProducts();
        demoSellProducts();
        demoRenameProductsById();
        demoRemoveProductsById();
        demoPrintProductByName("Apple");
        demoPrintProductByName("Samsung");
        demoPrintProductByName("128GB");
        demoPrintLowStock(1);
        demoPrintLowStock(2);
        demoPrintLowStock(3);
    }

    private void demoSellProducts()
    {
        System.out.println("\nSelling all the products\n");

        for(int id = 101; id <= 110; id++)
        {
            amount = generator.nextInt(8);
            manager.sellProduct(id, amount);
        }          

        manager.printAllProducts();
    }

    private void demoDeliverProducts()
    {
        System.out.println("\nDelivering all the products\n");

        for(int id = 101; id <= 110; id++)
        {
            // this will throw error when amount = 0.
            amount = generator.nextInt(8);
            manager.delivery(id, amount);
        }

        manager.printAllProducts();
    }

    private void demoRenameProductsById() 
    {
        System.out.println("\nRename a product\n");

        String newName = "NewName";
        int idToRename = generateRandomId(100, 11);
        System.out.println("\nRenaming product with ID: " + idToRename + " to new name " + newName);
        manager.renameProduct(idToRename, newName);
        manager.printAllProducts();
    }

    private void demoRemoveProductsById() 
    {
        int idToRemove = generateRandomId(100, 11);
        System.out.println("\nRemoving product with ID: " + idToRemove);
        manager.removeProduct(idToRemove);
        manager.printAllProducts();
    }

    private void demoPrintProductByName(String namePart) 
    {
        manager.printProductByName(namePart);

        System.out.println("Printing Products By Name: ");
    }

    private void demoPrintLowStock(int lowStockLevel)
    {
        manager.printLowStock(lowStockLevel);

        System.out.println("Printing low stock products");
    }

    private int generateRandomId(int min, int offset) 
    {
        return generator.nextInt(offset) + min;    
    }
}