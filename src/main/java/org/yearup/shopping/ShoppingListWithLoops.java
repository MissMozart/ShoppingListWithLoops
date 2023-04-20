package org.yearup.shopping;

import java.util.Scanner;

public class ShoppingListWithLoops {
    public static void main(String[] args) {

        System.out.println("Hello! We have in Stock: ");
        // Show the user a list of items for sale
        // Only show the Product names and IDs, not the prices

        Item[] itemsForSale = ItemsForSale.itemsForSale;

        for (Item i : itemsForSale) {
            if (! i.isInStock()) continue;
            System.out.print(i.getDescription());
            System.out.print(" , ProductID: ");
            System.out.println(i.getProductID());
        }

        // Invite them to buy something

        Scanner scanner = new Scanner(System.in);
        boolean sold = false;
        do {
            System.out.println("Which item would you like to buy? (Type in ProductID)");

            // Read in the user's response
            String consoleInput = scanner.nextLine();


            // Parse their choice and get that item from the list


            String selectedProductId = consoleInput;
            Item selectedItem = null;


            for (Item i : itemsForSale) {
                if (selectedProductId.equals(i.getProductID())) {
                    selectedItem = i;
                    break;
                } else if (selectedProductId.equals("STOP")) {
                    return;
                }
            }

            // Tell the user they can have it for a price
            System.out.println("The price is " + selectedItem.getPrice());

            //Ask them to accept the price
            System.out.println("Will you accept the price? (y/n)");
            // Read their response
            String answer2 = scanner.nextLine();
            //   if yes, tell them it's theirs
            //   if no, start over and show them the list again
            if (answer2.equals("y")) {
                System.out.println("Congrats! It's yours!");
                sold = true;
                selectedItem.setInStock(false);
            } else {
                System.out.println("Ok, what else would you like? Or say STOP.");

            }
        } while (! sold);
    }
}
