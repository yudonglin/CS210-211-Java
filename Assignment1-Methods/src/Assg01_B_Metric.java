/* 
 * CS210 Assignment 01 (Methods - The Metric Song)
 * Yudong Lin - yudong9912@gmail.com
 * Student ID: 950697082
 * 2019/1/9 - winter quarter
 *
 * This writes the lyrics to The Metric Song
 * I already try to minimize my code as short as possible.
 * Any better idea or bug please tell me
 */

public class Assg01_B_Metric {
    public static void part_a() {
    	 System.out.println("\nOh, metric. You¡¯re the one.\nYou make measuring more fun.\nBased on ten. Let¡¯s start again\nAnd go the metric way.");
    }
    public static void part_b() {
    	System.out.println("The Metric Song");
    	part_a();
        System.out.println("\nThere was once a family of giants\nAnd Kilo was their name.\nThey were all so huge and tall\nAnd no two were the same.");
    }
    public static void part_c() {
    	part_a();
    	System.out.println("\nThere also were some tiny elves\nWho had the name of Milli.\nOne one thousandth¡ªthey¡¯re so small\nTo think of them seems silly!");
    }
    public static void part_d() {
    	part_a();
        System.out.println("\nNow milligrams, they don¡¯t weigh much.\nAnd millimeters are short.\nA milliliter¡¯s a tiny drop\nOf liquid they report.");
        }
    public static void part_e() {
    	part_a();
    	System.out.println("\nSo, grams you may have noticed\nAre things you can weigh.\nLength is meter, liquid¡¯s liter.\nThat¡¯s the metric way.");
    }
    public static void main(String[] args) {
    	part_b();
    	part_c();
        part_d();
        part_e();
    }
}