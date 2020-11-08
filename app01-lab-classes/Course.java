/**
 * Describes the course and its code number. 
 *
 * @author Hamood Jaffery
 * @version 08.Oct.20 0.1
 */
public class Course
{ 
    private String title;
    private String codeNumber;
    
    /**
     * Constructor for objects of class Course
     */
    public Course(String title, String codeNumber)
    {
        this.title = title;
        this.codeNumber = codeNumber;
    }

    public void print()
    {
       System.out.println(title + ", codeNumber: " + codeNumber); 
    }
}
