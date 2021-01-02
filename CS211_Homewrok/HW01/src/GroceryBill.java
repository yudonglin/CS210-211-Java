// This is one of the classes for exercise 10 of Chapter 9
// used by permission from this student:
// CS211 Alperen Cucioglu 
// Homework Assignment 01
// 22 September 2019

public class GroceryBill {
   private double total_price;
   private int item_count;
   private Item receipt[];
   private Employee clerk;

   public GroceryBill(Employee clerk) { // Constructor with Employee parameter
      total_price = 0;
      item_count = 0;
      receipt = new Item[25];
      this.clerk = clerk;
   }
      
   public void add(Item i) { // Mutator method for adding an item 
      total_price += i.getPrice();
      receipt[item_count] = i;
      item_count += 1;
   }
   
   // Accessor methods
   public double getTotal() {
      return total_price;
   }
      
   public int getItemCount() {
      return item_count;
   }
   
   public String getCashierName() {
      return clerk.getName();
   }
   
   public void printReceipt() { // Printing the bill
      System.out.println("Cashier Name: " + clerk.getName());
      System.out.println(receiptToString()); 
      System.out.println("Total: $" + this.getTotal());
   }
   
   public String receiptToString() {
		String receiptText = "Items:\n";
		for(int i = 0; i < item_count; i++) {
			receiptText += "\t" + receipt[i];
			receiptText += "\n";
			}
		return receiptText;
      }
}