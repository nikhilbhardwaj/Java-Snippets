package textalot;

/**
 *
 * @author Nikhil
 * Mirrors the structure of the contacts table in the db
 */
public class Contact {
    public int cid;
    public String name,phone;
    
    public Contact(int id, String name, String phone)
    {
        this.cid = id;
        this.name = name;
        this.phone = phone;
    }
    
    @Override
    public String toString()
    {
        return name;
    }
}
