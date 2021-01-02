public class math_class_call {
	public static myMath value = new myMath();
	public static void main(String[] args) {		
			value.a = 10;
			value.b = 20;
			value.t = 10; //Temperature
			value.s = "F";
			int value_max = value.max();
			int value_min = value.min();
			int value_avg = value.avg();
			int value_sum = value.sum();
			int value_sumOdd = value.sumOdd();
			int value_sumEven = value.sumEven();
			boolean valeu_isEqualNumber = value.isEqualNumber();
			double value_convert = value.convert();
			System.out.println(value_max);
			System.out.println(value_min);
			System.out.println(value_avg);
			System.out.println(value_sum);
			System.out.println(value_sumOdd); 
			System.out.println(value_sumEven);	
			if(valeu_isEqualNumber==true) {
				System.out.println("Two numbers are equal");
			}else if(valeu_isEqualNumber==false){
				System.out.println("Two numbers are not equal");
			}else {
				System.out.println("Erro! Please check input for value.isEqualNumber().");
			}
			System.out.println(value_convert);
	}
}
