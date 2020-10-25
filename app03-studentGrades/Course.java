
/**
 * Describes the course and its code number. 
 *
 * @author Hamood Jaffery
 * @version 08.Oct.20 0.1
 */
public class Course
{
    // Variables for Title, codeNumber, and Module
    private String title;
    
    private String codeNo;

    private Module module1;    
    private Module module2;    
    private Module module3;    
    private Module module4;
    
    private int moduleNo;
    
    private int noModules;
    
    private int finalMark;
    
    private Grades finalGrade;
                        
    /**
     * Constructor for objects of class Course
     */
    public Course(String codeNo, String title)
    {
        this.title = title;
        this.codeNo = codeNo;
        noModules = 0;
        
        finalGrade = Grades.NULL;      
        createModule();
    }
    
    public void createModule()
    {
        module1 = new Module("Programming Concepts", "CO452");
        module2 = new Module("Digital Technologies and Professional Practice", "CO454");
        module3 = new Module("Computer Architectures", "CO450");
        module4 = new Module("Web Development", "CO456");
    }
    
    public void addModule(Module module)
    {
       noModules ++;
       
       if(noModules == 1)
       {
           module1 = module;
       }
    }
    
    public void setModuleMark(int mark, int moduleNO)
    {
      if(moduleNo == 1)
      {
          module1.setMark(mark);
          module2.setMark(mark);
          module3.setMark(mark);
          module4.setMark(mark);
      }
    }
    
    
    public void calculateFinalGrade()
    {
        if(finalMark < 40)
        {
            finalGrade = Grades.F;
        }
        else if((finalMark >= 40) && (finalMark < 50))
        {
            finalGrade = Grades.D;
        }
    }
    
    /**
     *  Prints out the details of a course
     */
    public void print()
    {
        System.out.println("Course " + codeNo + " - " + title);        
    }
}
