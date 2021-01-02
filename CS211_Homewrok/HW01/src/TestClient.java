// CS211 Yudong Lin 
// HW01
// 11 April 2020
public class TestClient {

	public static void main(String[] args) {
		//create Employee object
		Employee clerkToday =  new Employee("yudong");
		String hisName = clerkToday.getName();
		System.out.printf("Hello %s is here to help!", hisName);
		System.out.println();
		System.out.println("--------------");
		
		//create GroceryBill objects
		DiscountBill billOfToday_withPrefer = new DiscountBill(clerkToday, true);
		DiscountBill billOfToday_noPrefer = new DiscountBill(clerkToday, false);
		
		//check whether GroceryBill objects are initialized
		//billOfToday_withPrefer.printReceipt();
		//System.out.println("--------------");
		//billOfToday_noPrefer.printReceipt();
		
		//create Item(String name, double price, double discount)
		Item candyBar = new Item("candy bar",1.35,0.25);
		Item apple = new Item("apple",5.0,1.0);
		Item icecream = new Item("ice-cream",3.0,0.0);
		Item erroItem = new Item("erroItem",-3.0,-1.0);//in case negative input, should print warning
		
		
		//add the candyBar to both DiscountBill objects
		//Customer with Prefer
		billOfToday_withPrefer.add(candyBar);
		billOfToday_withPrefer.add(apple);
		billOfToday_withPrefer.add(apple);
		billOfToday_withPrefer.add(icecream);
		billOfToday_withPrefer.add(erroItem);
		//Customer without Prefer
		billOfToday_noPrefer.add(candyBar);
		billOfToday_noPrefer.add(apple);
		billOfToday_noPrefer.add(apple);
		billOfToday_noPrefer.add(icecream);
		
		
		
		//print receipt of GroceryBill objects
		billOfToday_withPrefer.printReceipt();
		System.out.println();
		System.out.println("Number of items: " + billOfToday_withPrefer.getItemCount());
		System.out.println("Number of items that were discounted: " + billOfToday_withPrefer.getDiscountCount());
		System.out.println("Total discount for list of items: " + billOfToday_withPrefer.getDiscountAmount());
		System.out.printf("Discount percent: %.2f", billOfToday_withPrefer.getDiscoutPrecent()*100);
		System.out.println("%");
		System.out.println("--------------");
		billOfToday_noPrefer.printReceipt();
		System.out.println();
		System.out.println("Number of items: " + billOfToday_noPrefer.getItemCount());
		System.out.println("Number of items that were discounted: " + billOfToday_noPrefer.getDiscountCount());
		System.out.println("Total discount for list of items: " + billOfToday_noPrefer.getDiscountAmount());
		System.out.printf("Discount percent: %.2f", billOfToday_noPrefer.getDiscoutPrecent()*100);
		System.out.println("%");
			
	}

}
