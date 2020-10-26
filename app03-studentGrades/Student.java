import java.util.*;

/**
 * The Student class represents a student in student's database system. It holds 
 * student's name, id number, course's name & credit. 
 * @Hamood Jaffery
 * @25.October.2020
 */
public class Student
{
    // the student's full name
    private String name;
    // the student ID
    private String id;
    
    private Course course;
    
    /**
     * Create a new student with a given name and ID number.
     */
    public Student(String fullName, String studentID)
    {
        name = fullName;
        id = studentID;
    }
    
    public void setCourse(Course course)
    {
      this.course = course;  
    }
    
    /**
     * Return the full name of this student.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set a new name for this student.
     */
    public void changeName(String replacementName)
    {
        name = replacementName;
    }

    /**
     * Return the student ID of this student.
     */
    public String getStudentID()
    {
        return id;
    }

    /**
     * Return the login name of this student. The login name is a combination
     * of the first four characters of the student's name and the first three
     * characters of the student's ID number.
     */
    public String getLoginName()
    {
        return name.substring(0,4) + id.substring(0,3);
    }
    
    /**
     * Print the student's name, student ID and marks
     */
    public void print()
    {
        System.out.println("Name: " + name + ", Student ID: " + id);
        if (course != null) {
            course.print();
        }
    }
}
