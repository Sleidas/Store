package Store;

import java.io.Serializable;
/**
 * C23364683
 * Sleidas Sabaliauskas
 * AthleticZone - Business
 */
public class Products implements Serializable
{
    // instance variables 
    private String name;
    private double price;
    private int stock;
    private String brand, gender, colour;

    //Constructor 1 - blank
    public Products()
    {
        this.name = "";
        this.price = 0.0;
        this.stock = 0;
        this.brand = "";
        this.gender = "";
        this.colour = "";
    }
    // Constructor 2
    public Products(String name, double price, int stock, String brand, String gender, String colour)
    {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.brand = brand;
        this.gender = gender;
        this.colour = colour;
    }

    //Getter methods
    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    public int getStock()
    {
        return stock;
    }

    public String getBrand()
    {
        return brand;
    }

    public String getGender()
    {
        return gender;
    }

    public String getColour()
    {
        return colour;
    }

    //setter methods
    public void setName(String name)
    {
        this.name = name;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public void setStock(int stock)
    {
        this.stock = stock;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public void setColour(String colour)
    {
        this.colour = colour;
    }

    public String toString()
    {
        return 
        "\nName: " + name +
        "\nPrice: " + price +
        "\nStock: " + stock + 
        "\nBrand: " + brand +
        "\nGender: " + gender + 
        "\nColour: " + colour;

    }
}
