public class myMath {	
	int a;
	int b;
	int return_value;
	String s;
	public int min() {
		if(a>b) {
			return_value = b;
		}else if(a<b) {
			return_value = a;
		}else {
			return_value = a;
		}
		return return_value;
	}
	public int max() {
		if(a>b) {
			return_value = a;
		}else if(a<b) {
			return_value = b;
		}else {
			return_value = a;
		}
		return return_value;
	}
	public int avg() {
		return_value = sum()/(b+1-a);
		return return_value;
	}
	public int sum() {
		return_value = 0;
		for(int i = a; i<=b; i++) {
			return_value += i;
		}
		return return_value;
	}
	public int sumOdd() {
		return_value = 0;
		for(int i = a; i<=b; i++) {
			if(i%2 != 0){
				return_value += i; 
		    }   
		}
		return return_value;
	}
	public int sumEven() {
		return_value = 0;
		for(int i = a; i<=b; i++) {
			if(i%2 == 0){
				return_value += i; 
		    }   
		}
		return return_value;
	}
	public boolean isEqualNumber(){
		boolean retueun_t_or_f;
		if(a==b) {
			retueun_t_or_f = true;
		}else {
			retueun_t_or_f = false;;
		}
		return retueun_t_or_f;
	}
	double t;
	public double convert() {
		double return_value = 0;
		if(s.toUpperCase().equals("F")) {
			return_value = (t-32)/1.8;
		}else if(s.toUpperCase().equals("C")) {
			return_value = t*1.8+32;
		}
		return return_value;
	}
}
