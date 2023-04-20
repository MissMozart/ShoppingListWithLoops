package org.yearup.shopping;

public class ShoppingListWithLoops {
    public static void main(String[] args) {

        Item[] itemsForSale = ItemsForSale.itemsForSale;
        for (Item i : itemsForSale) {
            System.out.println(i);
        }
    }
}
