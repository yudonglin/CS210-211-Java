// This is one of the classes for exercise 10 of Chapter 9
// used by permission from this student:
// CS211 Alperen Cucioglu 
// Homework Assignment 01
// 22 September 2019

public class Item {
   private String name;
   private double price;
   private double discount;

   public Item(String name, double price, double discount) { // Constructor 
      this.name = name;
      if (price >= 0) {
    	  this.price = price;
      } else {
    	  System.out.printf("Warning: The price of %s cannot be negative! The price is set to 0, but please edit the input ASAP.",name);
    	  System.out.println();
    	  this.price = 0;
      }
      if (discount >= 0) {
    	  this.discount = discount;
      } else {
    	  System.out.printf("Warning: The discount of %s cannot be negative! The price is set to 0, but please edit the input ASAP.",name);
    	  System.out.println();
    	  this.discount = 0;
      }
	}
   
   // Accessor methods
   public String getName() {
      return name;
   }
   
   public double getPrice() {
      return price;
   }
   
   public double getDiscount() {
      return discount;
   }
   
   public String toString() { // toString method for printing the receipt
		return name + ": $" + price + " (-$" + discount + ")";
   }

}
   