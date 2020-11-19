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

            String choice = input.getString();
            choice = choice. toUpperCase();

            if(choice.equals("QUIT"))
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
        if(choice.equals("ADD"))
        {
            addProduct();
        }
        else if(choice.equals("REMOVE"))
        {
            removeProduct();
        }
        else if(choice.equals("PRINTALL"))
        {
            printAllProducts();
        }   

    }

    /**
     * add a product
     */
    private void addProduct()
    {
        System.out.println("\nAdding a new prodcut");

        System.out.println("Enter the product name");
        String name = input.getString();

        System.out.println("Enter a product ID");
        String value = input.getString();

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
    
    private void removeProduct() 
    {
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
        System.out.println("    Add:        Add a new product");
        System.out.println("    Remove:     Remove an old product");
        System.out.println("    PrintAll:   Print all products");
        System.out.println("    Quit:       Quit the program");
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