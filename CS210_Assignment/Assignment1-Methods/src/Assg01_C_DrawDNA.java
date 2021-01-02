/* 
 * CS210 Assignment 01 (Methods - The Metric Song)
 * Yudong Lin - yudong9912@gmail.com
 * Student ID: 950697082
 * 2019/1/9 - winter quarter
 *
 * This draws a DNA like image.
 * I already try to minimize my code as short as possible.
 * Any better idea or bug please tell me
 */
public class Assg01_C_DrawDNA {
	
	public static void part_1() {
		System.out.println( "o-----G\no-----G\no-----G\no-----A\n o---T\n  /-T");
	}
	public static void part_2() {
		for (int i = 0; i < 4; i++) {
		System.out.println("   G\n  /-A\n o---C\no-----T\nO-----O\nT-----o\n C---o\n  A /");
	    }
	}
	public static void part_3() {
		System.out.println("   G\n  /-T\n o---T\r\no-----A\r\no-----G\r\no-----G\r\no-----G");
	}
	public static void main(String[] args) {
		part_1();
		part_2();
		part_3();
	}
}
