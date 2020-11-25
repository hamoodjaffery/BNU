/**
 * Stock management program for public.
 *
 * @author Hamood Jaffery
 * @date 19.Nov.2020
 */
public class Program
{
    private static StockApp app;
    
    /**
     * This class creates and runs an instance of
     * the StockApp class
     */
    public static void main()
    {
        app = new StockApp();
        app.run();
    }
}