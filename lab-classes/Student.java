/**
 * The Student class represents a student in a student administration system.
 */
public class Student extends Person
{
    private String id;
    private int credits;

    /**
     * Create a new student with a given name, contact info, and ID number.
     */
    public Student(String fullName, String contactInfo, String studentID)
    {
        super(fullName, contactInfo);
        id = studentID;
        credits = 0;
    }

    public String getStudentID()
    {
        return id;
    }

    public void addCredits(int additionalPoints)
    {
        credits += additionalPoints;
    }

    public int getCredits()
    {
        return credits;
    }

    public String getLoginName()
    {
        return getName().substring(0,4) + id.substring(0,3);
    }

    @Override
    public void print()
    {
        System.out.println(getName() + ", student ID: " + id + ", credits: " + credits + ", contact: " + getContactInfo());
    }
}
