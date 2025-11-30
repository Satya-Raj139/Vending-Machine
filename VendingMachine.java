import java.util.HashMap;
import java.util.Scanner;

public class VendingMachine
{
    public static void main(String args[])
    {
        HashMap<String,Item> inventory =new HashMap<>();
        inventory.put("A1", new Item("Chips", 20, 5));
        inventory.put("A2", new Item("Soda", 40, 2));
        inventory.put("B1", new Item("CandyBar", 1.50, 3));
        
       // System.out.println(inventory.get("A1"));

        

        Scanner scanner = new Scanner(System.in);
        while (true) 
        {
            
    
            System.out.println("--------------------");
            System.out.println("Welcome! Please select an item. ");
            for(String key : inventory.keySet())
            {
                System.out.println(key + ":" +inventory.get(key));
            }
            System.out.println("Enter Code (or 'exit' to quit): ");
            String selection = scanner.nextLine();
            if(selection.equalsIgnoreCase("exit"))
            {
                break;
            }
            
            System.out.println("You Selected:" + selection);

            try
            {
                if(!inventory.containsKey(selection))
                {
                    System.out.println("Sorry! Your enterd item doesn't exist");
                }
                else
                {
                    Item selecteditem=inventory.get(selection);

                    if(selecteditem.isOutofStock())
                    {
                        throw new OutOfStockException(selecteditem.getName() + "is sold out. Sorry!");
                    }
                    else
                    {
                        System.out.println("You selected :"+ selecteditem.getName() + ".Price: $" + selecteditem.getPrice());
                    }
                    System.out.println("Please insert Money");
                    double moneyInserted =scanner.nextDouble();
                    scanner.nextLine();
                    if(moneyInserted<selecteditem.getPrice())
                    {
                        System.out.println("Sorry! That's Not enough Money, Money Returnd");
                    }
                    else
                    {
                        double change=moneyInserted-selecteditem.getPrice();
                        selecteditem.dispense();

                        System.out.println("VendingMachine Thanks!");
                        System.out.println("Your Item is : " + selecteditem.getName());
                        System.out.println("Your Change :$" +String.format("%.2f", change));
                    }
                }
            }
            catch (OutOfStockException e)
            {
                System.out.println("Sorry " +e.getMessage());
            }
            catch (java.util.InputMismatchException e)
            {
                // 8. A "catch" block for when they type "two" instead of 2.00
                System.out.println("Error: Invalid money format. Please enter a number.");
                scanner.next();
            }

            System.out.println("\n...Waiting for next customer...\n");
        }
        System.out.println("Thank you for using the machine. Shutting down.");
        scanner.close();

    }
    
}
