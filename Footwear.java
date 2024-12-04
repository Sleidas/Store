package Store;

/**
 * C23364683
 * Sleidas Sabaliauskas
 * AthleticZone - Business
 */
public class Footwear extends Products
{
    // instance variables 
    private String type;
    private int size;

    //constructor 1 - blank
    public Footwear()
    {
        super();
        this.type = "";
        this.size = 0;
    }

    public Footwear(String name, double price, int stock, String brand, String gender, String colour, String type, int size)
    {
        super(name, price, stock, brand, gender, colour);
        this.type = type;
        this.size = size;
    }
    
    //getter methods
    public String getType()
    {
        return type;
    }
    public int getSize()
    {
        return size;
    }
    
    //setter methods
    public void setType()
    {
        this.type = type;
    }
    public void setSize()
    {
        this.size = size;
    }
    
    //toString
    /**using polymorphism to override the super class */
    public String toString()
    {
        return 
        super.toString() +
        "\nFootwear type: " + type +
        "\nSize: " + size;
    }
}
