/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Hamood Jaffery
 * @date 19.Nov.2020
 */
public class StockApp
{
    public static final String QUIT =    "Quit";
    public static final String ADD =     "Add";
    public static final String SELL =    "Sell";
    public static final String DELIVER = "Deliver";
    public static final String SEARCH =  "Search";
    public static final String REMOVE =  "Remove";
    public static final String RESTOCK = "Restock";
    public static final String PRINTALL ="Printall";

    // Use to get user input
    private InputReader input;

    private StockManager manager;

    private StockDemo demo;

    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        input = new InputReader();
        manager = new StockManager();
        demo = new StockDemo(manager);
    }

    /**
     * 
     */
    public void run()
    {
        boolean finished = false;
        while(!finished)
        {
            printHeading();
            printMenuChoices();

            String choice = input.getString("Please enter your choice >  ");
            choice = choice. toUpperCase();

            if(choice.equals(QUIT))
            {
                finished = true;
            }
            else
            {
                executeMenuChoice(choice);
            }
        }
    }

    private void executeMenuChoice(String choice)
    {
        if(choice.equals(ADD))
        {
            addProduct();
        }
        else if(choice.equals(REMOVE))
        {
            removeProduct();
        }
        else if(choice.equals(PRINTALL))
        {
            printAllProducts();
        }
        else if(choice.equals("LOW"))
        {
            processLowStock(true);
        }
        else if(choice.equals(SELL))
        {
            sellProduct();
        }
        else if(choice.equals(DELIVER))
        {
            deliverProduct();
        }
        else if(choice.equals(RESTOCK))
        {
            processLowStock(false);
        }
    }

    /**
     * add a product
     */
    private void addProduct()
    {
        System.out.println("\nAdding a new prodcut");

        String name = input.getString("Enter the product name");

        String value = input.getString("Enter a product ID");

        int id = Integer.parseInt(value);

        if(manager.isDuplicate(id))
        {
            System.out.println("Duplicate id!!");
        }
        else
        {
            Product product = new Product(id, name);

            manager.addProduct(product);

            System.out.println("\nNew Product added " + product + "\n");

        }

    }

    /**
     * Remove the product.
     */
    public void removeProduct()
    {
        System.out.println("\nRemoving a prodcut");

        int id = input.getInt("Enter a product ID");

        manager.removeProduct(id);
    }

    /**
     * Sell the product.
     */
    public void sellProduct()
    {
        System.out.println("\nSelling a product");

        System.out.println();
        int id = input.getInt("Enter a product ID");

        int quantity = input.getInt("Enter the product quantity");

        manager.sellProduct(id, quantity);
    }

    /**
     * Deliver product.
     */
    public void deliverProduct()
    {
        System.out.println("\nDelivering a Product");

        int id = input.getInt("Enter a product ID");

        int amount = input.getInt("Enter amount");        
        manager.delivery(id,amount);
    }

    /**
     * Search the product
     */
    public void searchProduct()
    {
        System.out.println("\nSearching a Product");

        String value = input.getString("Enter the name of a product");

        manager.printProductByName(value);        
    }

    /**
     * Low Stock will indicate products with low stock levels
     */
    private void processLowStock(boolean justPrint)
    {
        System.out.println("\nPrinting low level stocks"); 

        int lowValue = input.getInt("Please enter the stock level");

        if(!justPrint)
        {
            int newValue = input.getInt("Please enter the newstock level");
            manager.reStock(lowValue, newValue);
        }
        else
        {
            manager.printLowStock(lowValue);

        }
    }

    /**
     * print all the products
     */
    private void printAllProducts()
    {
        manager.printAllProducts();       
    }

    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("" + ADD + ":        Add a new product");
        System.out.println("" + REMOVE + ":     Remove an old product");
        System.out.println("" + DELIVER + ":    Delivering the stock");
        System.out.println("" + SELL + ":       Selling a product");
        System.out.println("" + RESTOCK + ":    Re-stocking low items");
        System.out.println("" + PRINTALL + ":   Print all products");
        System.out.println("" + SEARCH + ":     Searching the product");
        System.out.println("" + QUIT + " :      Quit the program");
        System.out.println();        
    }

    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println();
        System.out.println("******************************");
        System.out.println(" Stock Management Application ");
        System.out.println("    App05: by Hamood Jaffery");
        System.out.println("******************************");
    }
}