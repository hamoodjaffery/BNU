    /**
     * This app provides a user interface to the
     * stock manager so that users can add, edit,
     * print and remove stock products
     *
     * @name Hamood Jaffery
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
        public static final String LOWSTOCK = "Lowstock";
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
    
                if(choice.compareToIgnoreCase(QUIT) == 0)
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
            if(choice.compareToIgnoreCase(ADD) == 0)
            {
                addProduct();
            }
            else if(choice.compareToIgnoreCase(REMOVE) == 0)
            {
                removeProduct();
            }
            else if(choice.compareToIgnoreCase(PRINTALL) == 0)
            {
                printAllProducts();
            }
            else if(choice.compareToIgnoreCase(LOWSTOCK) == 0)
            {
                processLowStock(true);
            }
            else if(choice.compareToIgnoreCase(SELL) == 0)
            {
                sellProduct();
            }
            else if(choice.compareToIgnoreCase(DELIVER) == 0)
            {
                deliverProduct();
            }
            else if(choice.compareToIgnoreCase(RESTOCK) == 0)
            {
                processLowStock(false);
            }
            else if(choice.compareToIgnoreCase(SEARCH) == 0)
            {
                printProductByName();
            }
        }
    
        /**
         * add a product
         */
        private void addProduct()
        {
            System.out.println("\nAdding a new prodcut");
    
            String name = input.getString("Enter the product name");
    
            // while loop will run until user enters non blank name.
            while (isBlankString(name)) 
            {
                name = input.getString("Please re-enter name (empty name not allowed)");
            }
    
            String value = input.getString("Enter a product ID");
    
            while (isBlankString(value)) 
            {
                value = input.getString("Please re-enter ID (empty ID not allowed)");
            }
    
            int id = Integer.parseInt(value);
    
            while (manager.isDuplicate(id)) 
            {
                value = input.getString("Please re-enter ID (Duplicate ID)");
                while (isBlankString(value)) 
                {
                    value = input.getString("Please re-enter ID (empty ID not allowed)");
                }
                id = Integer.parseInt(value);
            }
    
            Product product = new Product(id, name);
            manager.addProduct(product);
            System.out.println("\nNew Product added " + product + "\n");
        }
    
        /**
         * Remove the product.
         */
        public void removeProduct()
        {
            System.out.println("\nRemoving a prodcut");
    
            int id = input.getInt("Enter a product ID");
            Product product = manager.findProduct(id);
    
            while (product == null) 
            {
                id = input.getInt("Invalid ID, Enter a valid product ID");
                product = manager.findProduct(id);
            }
    
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
            Product product = manager.findProduct(id);
    
            while (product == null) 
            {
                id = input.getInt("Invalid ID, Enter a valid product ID");
                product = manager.findProduct(id);
            }
    
            int quantity = input.getInt("Enter the product quantity");
    
            while (quantity < 1)
            {
                quantity = input.getInt("Invalid quantity entered! Enter quantity");
            }
    
            manager.sellProduct(id, quantity);
        }
    
        /**
         * Deliver product.
         */
        public void deliverProduct()
        {
            System.out.println("\nDelivering a Product");
    
            int id = input.getInt("Enter a product ID");
            Product product = manager.findProduct(id);
            while (product == null) 
            {
                id = input.getInt("Invalid ID, Enter a valid product ID");
                product = manager.findProduct(id);
            }
    
            int amount = input.getInt("Enter amount");
            while (amount < 1)
            {
                amount = input.getInt("Invalid amount entered! Enter amount");
            }
    
            manager.delivery(id,amount);
    
        }
    
        /**
         * Search the product by its name
         */
        public void printProductByName()
        {
            System.out.println("\nSearching a Product");
    
            String name = input.getString("Enter the product name > ");
            while (isBlankString(name))
            {
                name = input.getString("Empty name is not allowed to search! Please enter the product name > ");  
            }
            manager.printProductByName(name);        
        }
    
        /**
         * Low Stock will indicate products with low stock levels
         */
        private void processLowStock(boolean justPrint)
        {
            // if justprint then just print otherwise restock.
            if (justPrint) {                 
                int lowValue = input.getInt("Please enter the low stock level > ");
                System.out.println("\nPrinting low level stocks");
                manager.printLowStock(lowValue);
            } else {
                System.out.println("\nPrinting low level stocks and restocking.");
                int lowValue = input.getInt("Please enter the low stock level > ");
                int newValue = input.getInt("Please enter the new stock level > ");
                manager.reStock(lowValue, newValue);
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
        System.out.println("" + LOWSTOCK + ":   Prints low-stock items");
        System.out.println("" + RESTOCK + ":    Restocks low-stock items");
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

    private boolean isBlankString(String string) { 
        return string == null || string.trim().isEmpty(); 
    }
}