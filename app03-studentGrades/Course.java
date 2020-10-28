
/**
 * Describes the module's title, its number, and marks achieved in each of the modules.
 * @author Hamood Jaffery
 * @25.October.2020
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
   
    
    private int finalMark;
    
    private Grades finalGrade;
                        
    /**
     * Constructor for objects of class Course
     */
    public Course(String codeNo, String title)
    {
        this.title = title;
        this.codeNo = codeNo;
        
        finalGrade = Grades.NULL;
    }
       
    public void addModule(String moduleName, String moduleCode, int moduleNumber)
    {
        switch (moduleNumber) {
            case 1: 
            {
                module1 = new Module(moduleName, moduleCode);
                break;
            }
            
            case 2: 
            {
                module2 = new Module(moduleName, moduleCode);
                break;
            }

            case 3: 
            {
                module3 = new Module(moduleName, moduleCode);
                break;
            }

            case 4: 
            {   
                module4 = new Module(moduleName, moduleCode);
                break;
            }

            default:
                System.out.println("Only 4 modules are allowed." + 
                "Please use module numbers 1 to 4.");
        }
    }
    
    public void setModuleMark(int mark, int moduleNumber)
    {
        switch (moduleNumber) {
            case 1:
            {
                module1.setMark(mark);
                break;
            }
            
            case 2:
            {
                module2.setMark(mark);
                break;
            }

            case 3: 
            {
                module3.setMark(mark);
                break;
            }

            case 4: 
            {
                module4.setMark(mark);
                break;
            }

            default:
                System.out.println("Only 4 modules are allowed." + 
                "Please use module numbers 1 to 4.");
    }
}


public void calculateFinalGrade()
{
    finalMark = (module1.getMark() 
        + module2.getMark() 
        + module3.getMark() 
        + module4.getMark()) / 4; 
   
    if (finalMark >= 70) {
        finalGrade = Grades.A;
    }
    else if (finalMark >= 60) 
    {
        finalGrade = Grades.B;
    }
    else if (finalMark >= 50)
    {
        finalGrade = Grades.C;
    }
    else if (finalMark >= 40)
    {
        finalGrade = Grades.D;
    }
    else 
    {
        finalGrade = Grades.F;
    }
}

/**
 *  Prints out the details of a course
 */
public void print()
{
    System.out.println("Course " + codeNo + " - " + title);  
    if (module1 !=null)
    {
        module1.print();
    }
    
    if (module2 !=null)        
        module2.print();
        
    if (module3 !=null)        
        module3.print();
    
    if (module4 !=null)   
        module4.print();
        
        System.out.println("Final Marks: " + finalMark + ", Grade: " + finalGrade);  
    }
}
