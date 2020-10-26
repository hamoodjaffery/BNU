
/**
 * Module class defines the title, code num, mark and completion status of the module.
 * @Hamood Jaffery
 * @25.October.2020
 */
public class Module
{
    private String title;
    
    private String codeNo;
    
    private int mark;
    
    private boolean completed;
    
    /**
     * Constructor of class Module stating its mark, title, code num & completed or not.
     */
    public Module(String title, String codeNo)
    {
        mark = 0;
        this.title = title;
        this.codeNo = codeNo;
        completed = false;
    }

    public void setMark(int mark)
    {
       if((mark >= 0)  && (mark <=100))
       { 
           this.mark = mark;
           if(mark >= 40) completed = true;
       }
    }
        
    public boolean isCompleted()
    {
        return completed;
    }
    
    public int getMark()
    {
       return mark;        
    }
    
    /** Prints module's title, code num and achieved marks.
     * 
     * 
     */
    public void print()
    {
        System.out.println("Title: " + title + ", CodeNumber: " + codeNo + ", Mark: " + mark);      
    }
}
