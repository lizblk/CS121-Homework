/**
 * The Instructor class represents an instructor.
 */
public class Instructor extends Person
{
    private String officeRoom;

    /**
     * Create a new instructor with a given name, contact info, and office room
     */
    public Instructor(String fullName, String contactInfo, String officeRoom)
    {
        super(fullName, contactInfo);
        this.officeRoom = officeRoom;
    }

    public String getOfficeRoom()
    {
        return officeRoom;
    }

    public void changeOfficeRoom(String newRoom)
    {
        officeRoom = newRoom;
    }

    @Override
    public void print()
    {
        System.out.println(getName() + ", office: " + officeRoom + ", contact: " + getContactInfo());
    }
}
