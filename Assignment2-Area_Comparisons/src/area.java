import java.util.*;

/*
1) Yudong Lin
2) If there is any problem, please hand in here: https://github.com/yoshino-lin/Assignment-2-Area-Comparisons
3) 950697081
4) 1/25/2019
5) This is a program that will calculate the areas of the shapes that you choose and compare their area.
*/

public class area {
	public static Scanner console = new Scanner(System.in); //public scanner
    public static double formatDouble1(double number_in) {
        return (double)Math.round(number_in*100)/100;  //round the number to two Decimal points
    }
    public static List<String> rectangle_area_cal() { //use to deal with rectangle_area
		System.out.print("Rectangle width: ");
		int rectangle_width_input = console.nextInt();
		System.out.print("Rectangle Height: ");
		int rectangle_height_input = console.nextInt();
		String area = rectangle_width_input*rectangle_height_input+""; //area value now changes from int to str
		System.out.println("Rectangle area: "+ area);
		List<String> shape_area_return =new ArrayList<>(); //a list is create to return the shape info
		shape_area_return.add("rectangle");
		shape_area_return.add(area);
		return shape_area_return; //{"rectangle",str(area)} is returned
    }
    public static List<String> triangle_area_cal() {
		System.out.print("Triangle width: ");
		int triangle_width_input = console.nextInt();
		System.out.print("Triangle Height: ");
		int triangle_height_input = console.nextInt();
		String area = triangle_width_input*triangle_height_input/2+"";
		System.out.println("Triangle area: "+area);	
		List<String> shape_area_return =new ArrayList<>();
		shape_area_return.add("triangle");
		shape_area_return.add(area);
		return shape_area_return;
    }
    public static List<String> circle_area_cal() {
		System.out.print("Circle radius: ");
		int circle_radius_input = console.nextInt();
		double circle_area = Math.PI*Math.pow(circle_radius_input,2); // =3.14*circle_radius_input*circle_radius_input
		circle_area = formatDouble1(circle_area); //round the result to two Decimal points
		System.out.println("Circle area: "+circle_area);
		List<String> shape_area_return =new ArrayList<>();
		shape_area_return.add("circle");
		String area = circle_area+"";
		shape_area_return.add(area);
		return shape_area_return;
    }
	public static List<String> shapeInfo() {
		System.out.print("Define a first shape (1)rectangle, 2)triangle, 3)circle):");
		int chooose_define_input = console.nextInt();
		List<String> area_cal = null;  //area_cal need to be define as null for the coming return list value
		if (chooose_define_input == 1) {
			area_cal = rectangle_area_cal();
		} else if (chooose_define_input == 2) {
			area_cal = triangle_area_cal();
		} else if (chooose_define_input == 3) {
			area_cal = circle_area_cal();
		}
		System.out.println("");
		return area_cal; //{"rectangle",str(area)} will be returned again
	}
	public static void main(String[] args) {
		List<String> area_1 = shapeInfo();
		List<String> area_2 = shapeInfo();
		double shape_area_1 = Double.valueOf(area_1.get(1).toString()); //area of the first shape
		double shape_area_2 = Double.valueOf(area_2.get(1).toString()); //area of the second shape
		if (shape_area_1 > shape_area_2) {
			System.out.println("The area of the "+area_1.get(0)+" seems bigger than the area of the "+area_2.get(0)+".");
		} else if (shape_area_1 < shape_area_2) {
			System.out.println("The area of the "+area_2.get(0)+" seems bigger than the area of the "+area_1.get(0)+".");
		} else {
			System.out.println("The area of the "+area_1.get(0)+" seems same as the area of the "+area_2.get(0)+".");
		}
	}
}
