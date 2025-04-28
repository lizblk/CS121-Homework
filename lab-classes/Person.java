/**
 * A Person has a name and contact details.
 */
public class Person
{
    private String name;
    private String contactInfo;  //add email/phone, etc.

    /**
     * Create a new person with the given name and contact info.
     */
    public Person(String name, String contactInfo)
    {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    /**
     * Return the person's name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Return the person's contact information.
     */
    public String getContactInfo()
    {
        return contactInfo;
    }

    /**
     * Change the person's name.
     */
    public void changeName(String newName)
    {
        name = newName;
    }

    /**
     * Change the person's contact information.
     */
    public void changeContactInfo(String newContactInfo)
    {
        contactInfo = newContactInfo;
    }

    /**
     * Print the person's information.
     */
    public void print()
    {
        System.out.println(name + ", contact: " + contactInfo);
    }
}
