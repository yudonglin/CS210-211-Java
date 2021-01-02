// CS211 Yudong Lin 
// HW01
// 11 April 2020
public class DiscountBill extends GroceryBill {
	public double discountAmount;
	public boolean ifPreferred;
	public int discountItemNum;
	
	public DiscountBill(Employee clerk, boolean preferred) {
		super(clerk);
		discountAmount = 0.0;
		discountItemNum = 0;
		ifPreferred = preferred;
	}
	
	//edit add to calculate discount items
	public void add(Item i) { // Mutator method for adding an item 
		super.add(i);
		//check the discount amount
		double discountTemp = i.getDiscount();
		//if customer is preferred and discount number greater than 0
		if (ifPreferred == true && discountTemp > 0) {
			discountAmount += discountTemp;
			discountItemNum ++;
		}
	}
	
	@Override
	public double getTotal(){
		if (ifPreferred==true) {
			return super.getTotal()-discountAmount;
		}else {
			return super.getTotal();
		}
	}
	
	public int getDiscountCount() {
		return discountItemNum;
	}
	
	public double getDiscountAmount() {
		return discountAmount;
	}
	
	public double getDiscoutPrecent() {
		return discountAmount/super.getTotal();
	}

}
