/* 
 * CS210 Assignment 01 (Methods - Sequence)
 * Yudong Lin - yudong9912@gmail.com
 * Student ID: 950697082
 * 2019/1/9 - winter quarter
 *
 * This program is a short puzzle.
 * It is very easy to use, any but report or issue please leave me a message.
 */

public class Assg01_A_Methods {

    public static void first() {
        System.out.println("first method");
        third(); //System.out.println("third method");
        
    }

    public static void second() {
        System.out.println("second method");
        first(); //System.out.println("first method"); and third();//System.out.println("third method");

        
    }
 
    public static void third() {
        System.out.println("third method");
        
        
    } 
 
    public static void main(String[] args) {
    // DO NOT change this main method
       first();
       third();
       second();
       third();;
    // DO NOT change this main method
    }

}


// Desired output:
/*
first method
third method
third method
second method
first method
third method
third method
*/
