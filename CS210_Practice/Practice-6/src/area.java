
public class area {
	public static void mystery2(int a, int b) {
		if (a<b) {
			a *= 2;
		}
		if (a>b) {
			a -= 10;
		}
		else {
			b++;
		}
		System.out.println(a+" "+b);
	}
	public static void main(String[] args) {
/*
		double height = 5.5;
		double base = 10.0;
		double radius = 3.0;
		double triArea = tri_area(height,base);
		double cirArea = cri_area(radius);
		cri_area(radius);
		System.out.println("area of triangle = "+triArea);
		System.out.println("area of circle = "+cirArea);
	}
	
	public static double tri_area(double height_input, double base_input) {
		double triArea = height_input * base_input * 0.5;
		return triArea;
	}
	
	public static double cri_area(double radius_input) {
		double cirArea = radius_input * radius_input * 3.14;
		return cirArea;
*/
		mystery2(4,20);
		}
}
