package Store;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
/**
 * C23364683
 * Sleidas Sabaliauskas
 * AthleticZone - Business
 */
public class Driver
{
    private ArrayList<Products> product;
    private boolean correct;

    //constructor
    public Driver()
    {
        Scanner scan = new Scanner(System.in); 
        int menuOption = 0;
        int menuOption1 = 0;
        int menuOption2 = 0;
        String delay;

        product = new ArrayList<Products>();

        do
        {
            menuOption = Menu1();

            if (menuOption == 1)
            {
                do
                {
                    menuOption1 = customerMenu();
                    if (menuOption1 == 1)
                    {
                        displayFootwear();
                    }

                    if (menuOption1 == 2)
                    {
                        displayApparel();
                    }

                    if (menuOption1 == 3)
                    {
                        purchaseFootwear();
                    }

                    if (menuOption1 == 4)
                    {
                        purchaseApparel();
                    }

                    if (menuOption1 == 5)
                    {
                        String discount1 = "TUD2024";
                        boolean correct = true;
                        String discount;
                        System.out.println("\nEnter discount (Case sensitive)");
                        discount = scan.nextLine();

                        if (discount.equals(discount1))
                        {
                            correct = true;
                            System.out.println("Discount code is correct, you are entitled to 20% off!");

                            discountCus();
                        }
                        else
                        {correct = false;
                        }
                    }
                }while(menuOption1 != 6);

            }

            if (menuOption == 2) {
                String password1 = "Staff2024";
                int maxAttempts = 3;
                int attempts = 0;
                boolean correct = false;

                do {
                    attempts++;
                    System.out.println("\nEnter password (Case sensitive): ");
                    String password = scan.nextLine();

                    if (password.equals(password1)) {
                        correct = true;
                        System.out.println("Access granted - Welcome to the staff menu!");

                        menuOption2 = staffMenu();

                        if (menuOption2 == 1) {
                            addingStockF();
                        } 
                        else if (menuOption2 == 2) {
                            addingStockA();
                        } 
                        else if (menuOption2 == 3) {
                            delivery();
                        } 
                        else if (menuOption2 == 4) {
                            staffDiscount();
                        }

                        break; // Exiting the loop if password is correct
                    } else {
                        System.out.println("Access denied - Password is incorrect.");
                    }

                    if (attempts >= maxAttempts) {
                        System.out.println("Error: Three unsuccessful attempts. Returning to main menu.");
                        delayClear();
                        break; // Exiting the loop if maximum attempts exceeded
                    }
                } while (true);
            }
        }while (menuOption != 3);

    }

    // Method to save stock items to binary file.
    public static void saveStockToFile(ArrayList<Products> stockItems) {
        String filename = "stock_items.dat"; 
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(stockItems);
            System.out.println("Stock items saved to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving stock items to file: " + e.getMessage());
        }
    }
    //display menu 

    public int Menu1()
    {
        Scanner scan=new Scanner(System.in);
        int menuOption = 0;

        System.out.print("\f");

        System.out.println(" ~~~~ AthleticZone ~~~~ ");
        System.out.println("\n1.Customer menu ");
        System.out.println("2.Staff menu (password protected)");
        System.out.println("3.Exit system.");

        System.out.println("Please select an option from 1-3.");
        menuOption = scan.nextInt();
        scan.nextLine();

        return menuOption;
    }

    //Display customer menu for option 1.
    public int customerMenu()
    {
        Scanner scan=new Scanner(System.in);
        int menuOption1 = 0;

        System.out.print("\f");

        System.out.println(" ~~~~ AthleticZone ~~~~ ");
        System.out.println("\n1.Display footwear for sale. ");
        System.out.println("2.Display apparel for sale");
        System.out.println("3.Purchase footwear.");
        System.out.println("4.Purchase apparel.");
        System.out.println("5.Purchase with discount.");
        System.out.println("6.Return to main menu.");

        System.out.println("Please select an option from 1-6.");
        menuOption1 = scan.nextInt();
        scan.nextLine();

        return menuOption1;
    }

    //.  Display staff menu, once password is input correctly.
    public int staffMenu()
    {
        Scanner scan=new Scanner(System.in);
        int menuOption2 = 0;

        System.out.print("\f");

        System.out.println(" ~~~~ AthleticZone ~~~~ ");
        System.out.println("1.Add new footwear to the stock list. ");
        System.out.println("2.Add new apparel to the stock list. ");
        System.out.println("3.Update stock level with new delivery. ");
        System.out.println("4.Purchase with staff discount (25% off!). ");
        System.out.println("5.Return to main menu. ");

        System.out.println("Please select an option from 1-5.");
        menuOption2 = scan.nextInt();
        scan.nextLine();

        return menuOption2;
    }

    //displaying footwear
    public void displayFootwear()
    {
        boolean found = false;
        for (Products p : product)
        {
            if(p instanceof Footwear)
            {
                found = true;
                System.out.println(p.toString());
            }

        }

        if (!found)
            System.out.println("Sorry, there are no items available in stock");

        delayClear();
    }

    //displaying apparel
    public void displayApparel()
    {
        boolean found = false;
        for (Products p : product)
        {
            if(p instanceof Apparel)
            {
                found = true;
                System.out.println(p.toString());
            }

        }

        if (!found)
            System.out.println("Sorry, there are no items available in stock");
        delayClear();
    }
    //purchasing footwear
    public void purchaseFootwear()
    {
        Scanner scan=new Scanner(System.in);
        String type;
        int size = 0;
        int stock, newStock = 0;
        double price = 0.0;
        Footwear f = null;
        boolean found = false;

        for (Products p : product)
        {
            if(p instanceof Footwear)
            {
                found = true;
                System.out.println(p.toString());
            }

        }

        System.out.println("Enter the product type you would like to purchase (Running/football etc..): ");
        type = scan.nextLine();

        System.out.println("Enter the shoe size you would like to purchase: ");
        size = scan.nextInt();

        for (Products p : product)
        {

            if( p instanceof Footwear)
            {

                f = (Footwear) p; // cast operator
                if(type.equalsIgnoreCase(f.getType()) && size == f.getSize())
                {
                    found = true;
                    System.out.println("Enter the quantity you would like to purchase: ");
                    stock = scan.nextInt();

                    newStock = f.getStock();

                    if(f.getStock()>0)
                    {
                        System.out.println("Thank you for your purchase..");
                        price = stock * p.getPrice();
                        System.out.println("Your total was " + price);
                        //decrease stock after purchase

                        newStock = p.getStock() - stock;
                        p.setStock(newStock);
                        System.out.println("There are now " + p.getStock() + " shoes in stock");
                    }
                    else if(f.getStock()<=0)
                    {
                        System.out.println("Sorry, there is not enough stock for your purchase.");
                    }

                }

            } 
        }
        if (!found)
        {
            System.out.println("Sorry this item is not available..");
        }
        delayClear();
    }
    
    //purchasing apparel
    public void purchaseApparel()
    {
        Scanner scan=new Scanner(System.in);
        String brand;
        String size;
        String category;
        double price = 0.0;
        int stock, newStock = 0;
        boolean found = false;

        Apparel a = null;

        for (Products p : product)
        {
            if(p instanceof Apparel)
            {
                found = true;
                System.out.println(p.toString());
            }

        }

        System.out.println("Enter the brand: ");
        brand = scan.nextLine();

        System.out.println("Enter the category of your product (Jacket/Pants etc...): ");
        category = scan.nextLine();

        System.out.println("Enter the size you would like to buy (S/M/L/XL): ");
        size = scan.nextLine();

        if (!size.equalsIgnoreCase ("S") && !size.equalsIgnoreCase("M") && !size.equalsIgnoreCase("L") && !size.equalsIgnoreCase("XL") )
        {
            found = false;
            System.out.println("This size is not available.. ");
        }

        for (Products p : product)
        {
            if (p instanceof Apparel)
            {
                a = (Apparel) p; //cast operator
                found = true;
                if(brand.equalsIgnoreCase(a.getBrand()) && category.equalsIgnoreCase(a.getCategory()) && size.equalsIgnoreCase(a.getSize()))
                {
                    System.out.println("Enter the quantity you would like to purchase: ");
                    stock = scan.nextInt();

                    newStock = a.getStock();
                    if(p.getStock()>0)
                    {
                        System.out.println("Thank you for your purchase..");
                        price = stock * p.getPrice();
                        System.out.println("Your total was " + price);
                        //decrease stock after purchase

                        newStock = p.getStock() - stock; 
                        a.setStock(newStock);
                        System.out.println("There are now " + p.getStock() + " clothes in stock");
                    }
                    else if(p.getStock()<=0)
                    {
                        System.out.println("Sorry, there is not enough stock for your purchase.");
                    }

                }

            }

        }
        if (!found)
        {
            System.out.println("Sorry this item is not available..");
        }
        delayClear();
    }

    //purchasing with discount
    public void discountCus()
    {
        Scanner scan=new Scanner(System.in);
        String option;
        String name, brand;
        Footwear f = null;
        Apparel a = null;
        int quantity;
        int newStock;
        double price;
        double discount = 0.8;

        System.out.println("Do you wish to purchase Footwear or Apparel? ");
        option = scan.nextLine();

        if (option.equalsIgnoreCase ("Footwear"))
        {  
            //details will be input to recognize footwear 
            System.out.print("\nInput the name of footwear: ");
            name = scan.nextLine();

            System.out.print("\nInput the brand of the footwear: ");
            brand = scan.nextLine();

            for (Products p : product)
            {
                if (p instanceof Footwear)
                {
                    f = (Footwear) p; //cast operator
                    if(name.equalsIgnoreCase(f.getName()) && brand.equalsIgnoreCase(f.getBrand()))
                    {
                        System.out.print("What is the quantity of your purchase? ");
                        quantity = scan.nextInt();
                        scan.nextLine();

                        if(p.getStock()>0)
                        {
                            System.out.println("Thank you for your purchase..");
                            price = quantity * p.getPrice();
                            price = price * discount;
                            System.out.println("Your total was " + price);

                        }
                        else if(p.getStock()<=0)
                        {
                            System.out.println("Sorry, there is not enough stock for your purchase.");
                        }

                        //decreasing after purchase
                        newStock = p.getStock() - quantity;
                        p.setStock(newStock);

                    }
                }
            }

        }
        else if (option.equalsIgnoreCase ("Apparel"))
        {
            //details will be input for Apparel 
            System.out.print("\nInput the name of clothing: ");
            name = scan.nextLine();

            System.out.print("\nInput the brand of the clothing: ");
            brand = scan.nextLine();

            for (Products p : product)
            {
                if (p instanceof Apparel)
                {
                    a = (Apparel) p; //cast operator
                    if(name.equalsIgnoreCase(a.getName()) && brand.equalsIgnoreCase(a.getBrand()))
                    {
                        System.out.print("What is the quantity of your purchase? ");
                        quantity = scan.nextInt();
                        scan.nextLine();

                        if(p.getStock()>0)
                        {
                            System.out.println("Thank you for your purchase..");
                            price = quantity * p.getPrice();
                            price = price * discount;
                            System.out.println("Your total was " + price);

                        }
                        else if(p.getStock()<=0)
                        {
                            System.out.println("Sorry, there is not enough stock for your purchase.");
                        }

                        //decreasing after purchase
                        newStock = p.getStock() - quantity;
                        p.setStock(newStock);

                        System.out.println("Stock has been updated, your new stock quantity is " + newStock);

                    }
                }
            }
        }
        else
        {
            System.out.println("Please input a valid product..");
        }
        delayClear();

    }
  //adding stock to footwear
    public void addingStockF()
    {
        Scanner scan=new Scanner(System.in);

        String name;
        double price; 
        int stock = 0;
        String brand, gender, colour, type;
        int size;

        System.out.println("~~ Adding footwear stock ~~ ");

        /** input the variables related to each product and add to the list.*/
        System.out.print("\nInput name of the footwear:");
        name = scan.nextLine();

        System.out.println("\nInput price of the footwear:");
        price = scan.nextInt();
        scan.nextLine();

        System.out.println("Brand will include (Nike,Adidas,Puma etc..)");
        System.out.print("\nInput brand of the footwear:");
        brand = scan.nextLine();

        System.out.print("\nInput gender of the footwear:");
        gender = scan.nextLine();

        System.out.print("\nInput colour of the footwear:");
        colour = scan.nextLine();

        System.out.println("Type should include categories like (running, football, casual)");
        System.out.print("\nInput the type of the footwear:");
        type = scan.nextLine();

        System.out.print("\nInput size of the footwear:");
        size = scan.nextInt();

        System.out.print("\nEnter quantity of the shoe you want to add");
        stock = scan.nextInt();

        //creating footwear - adding it to the stock
        Footwear f = new Footwear(name, price, stock, brand, gender,colour,type,size);
        product.add(f);
        delayClear();

    }
    //adding stock to apparel

    public void addingStockA()
    {
        Scanner scan=new Scanner(System.in);

        String name;
        double price;
        int stock=0;
        String brand, gender, colour, size, category;

        System.out.println("~~ Adding apparel stock ~~ ");
        /** input the variables related to each product and add to the list.*/
        System.out.print("\nInput name of the clothing:");
        name = scan.nextLine();

        System.out.println("\nInput price of the clothing:");
        price = scan.nextDouble();
        scan.nextLine();

        System.out.println("Brand will include (Nike,Adidas,Puma etc..)");
        System.out.print("\nInput brand of the clothing:");
        brand = scan.nextLine();

        System.out.print("\nInput gender of the clothing:");
        gender = scan.nextLine();

        System.out.print("\nInput colour of the clothing:");
        colour = scan.nextLine();

        System.out.println("Category will include (Hoodie, Trousers, T-Shirt etc...)");
        System.out.print("\nInput category of the clothing:");
        category = scan.nextLine();

        System.out.print("\nInput size of clothing: ");
        size = scan.nextLine();

        System.out.print("\nEnter quantity of the clothing you want to add");
        stock = scan.nextInt(); scan.nextLine();

        //creating Apparel - adding it to the stock
        Apparel a = new Apparel(name, price, stock, brand, gender,colour,size,category);
        product.add(a);
        delayClear();
    }

    //Updating stock level with new delivery.
    public void delivery()
    {
        Scanner scan = new Scanner(System.in);
        String delivery;
        int deliv;
        int stock;
        int newStock;
        Footwear f = null;
        Apparel a = null;
        String name, brand;
        System.out.println("Do you wish to input a delivery for Footwear or Apparel? ");
        delivery = scan.nextLine();

        if (delivery.equalsIgnoreCase ("Footwear"))
        {
            //details will be input for footwear 
            System.out.print("\nInput the name of footwear: ");
            name = scan.nextLine();

            System.out.print("\nInput the brand of the footwear: ");
            brand = scan.nextLine();

            for (Products p : product)
            {
                if (p instanceof Footwear)
                {
                    f = (Footwear) p; //cast operator
                    if(name.equalsIgnoreCase(f.getName()) && brand.equalsIgnoreCase(f.getBrand()))
                    {
                        System.out.print("What is the quantity of your delivery? ");
                        deliv = scan.nextInt();
                        scan.nextLine();

                        stock = p.getStock();
                        newStock = stock + deliv;
                        p.setStock(newStock);

                        System.out.println("Stock has been updated, your new stock quantity is " + newStock);

                    }
                }
            }

        }
        else if (delivery.equalsIgnoreCase ("Apparel"))
        {
            //details will be input for Apparel 
            System.out.print("\nInput the name of clothing: ");
            name = scan.nextLine();

            System.out.print("\nInput the brand of the clothing: ");
            brand = scan.nextLine();

            for (Products p : product)
            {
                if (p instanceof Apparel)
                {
                    a = (Apparel) p; //cast operator
                    if(name.equalsIgnoreCase(a.getName()) && brand.equalsIgnoreCase(a.getBrand()))
                    {
                        System.out.print("What is the quantity of your delivery? ");
                        deliv = scan.nextInt();
                        scan.nextLine();

                        stock = p.getStock();
                        newStock = stock + deliv;
                        p.setStock(newStock);

                        System.out.println("Stock has been updated, your new stock quantity is " + newStock);

                    }
                }
            }
        }
        else
        {
            System.out.println("Please input a valid product..");
        }
        delayClear();
    }

    public void staffDiscount()
    {
        Scanner scan = new Scanner(System.in);

        String option;
        String name, brand;
        Footwear f = null;
        Apparel a = null;
        int quantity;
        int newStock;
        double price;
        double discount = 0.75;

        System.out.println("--You are entitled to 25% off your order--");

        System.out.println("\nDo you wish to purchase Footwear or Apparel? ");
        option = scan.nextLine();

        if (option.equalsIgnoreCase ("Footwear"))
        {  
            //details will be input to recognize footwear 
            System.out.print("\nInput the name of footwear: ");
            name = scan.nextLine();

            System.out.print("\nInput the brand of the footwear: ");
            brand = scan.nextLine();

            for (Products p : product)
            {
                if (p instanceof Footwear)
                {
                    f = (Footwear) p; //cast operator
                    if(name.equalsIgnoreCase(f.getName()) && brand.equalsIgnoreCase(f.getBrand()))
                    {
                        System.out.print("What is the quantity of your purchase? ");
                        quantity = scan.nextInt();
                        scan.nextLine();

                        if(p.getStock()>0)
                        {
                            System.out.println("Thank you for your purchase..");
                            price = quantity * p.getPrice();
                            price = price * discount;
                            System.out.println("Your total was " + price);

                        }
                        else if(p.getStock()<=0)
                        {
                            System.out.println("Sorry, there is not enough stock for your purchase.");
                        }

                        //decreasing after purchase
                        newStock = p.getStock() - quantity;
                        p.setStock(newStock);

                        System.out.println("Stock has been updated, your new stock quantity is " + newStock);

                    }
                }
            }

        }
        else if (option.equalsIgnoreCase ("Apparel"))
        {
            //details will be input for Apparel 
            System.out.print("\nInput the name of clothing: ");
            name = scan.nextLine();

            System.out.print("\nInput the brand of the clothing: ");
            brand = scan.nextLine();

            for (Products p : product)
            {
                if (p instanceof Apparel)
                {
                    a = (Apparel) p; //cast operator
                    if(name.equalsIgnoreCase(a.getName()) && brand.equalsIgnoreCase(a.getBrand()))
                    {
                        System.out.print("What is the quantity of your purchase? ");
                        quantity = scan.nextInt();
                        scan.nextLine();

                        if(p.getStock()>0)
                        {
                            System.out.println("Thank you for your purchase..");
                            price = quantity * p.getPrice();
                            price = price * discount;
                            System.out.println("Your total was " + price);

                        }
                        else if(p.getStock()<=0)
                        {
                            System.out.println("Sorry, there is not enough stock for your purchase.");
                        }

                        //decreasing after purchase
                        newStock = p.getStock() - quantity;
                        p.setStock(newStock);

                        System.out.println("Stock has been updated, your new stock quantity is " + newStock);

                    }
                }
            }
        }
        else
        {
            System.out.println("Please input a valid product..");
        }
        delayClear();

    }
    public void delayClear()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPress enter to return..");
        scan.nextLine();
        System.out.print("\f");

    }

    public static void main(String[] args)
    {
        Driver driv1 = new Driver();
        driv1.saveStockToFile(driv1.product);
    }
}

    