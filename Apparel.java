package Store;


/**
 * C23364683
 * Sleidas Sabaliauskas
 * AthleticZone - Business
 */
public class Apparel extends Products
{
    // instance variables 
    private String size;
    private String category;

    //constructor 1 - blank
    public Apparel()
    {
        super();
        this.size = "";
        this.category = "";
    }
    //constructor 2
    public Apparel(String name, double price, int stock, String brand, String gender, String colour, String size, String category)
    {
        super(name, price, stock, brand, gender, colour);
        this.size = size;
        this.category  = category;
    }

    //getter methods 
    public String getSize()
    {
        return size;
    }

    public String getCategory()
    {
        return category;
    }

    public void setSize(String size)
    {
        this.size = size;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    //toString 
    /**using polymorphism to override the super class */
    public String toString()
    {
        return super.toString() +
        "\nCategory: " + category +
        "\nSize: " + size;
    }
}
