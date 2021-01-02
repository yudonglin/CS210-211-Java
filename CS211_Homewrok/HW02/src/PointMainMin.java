// CS211 Yudong Lin 
// HW02
// 18 April 2020
import java.util.ArrayList;
import java.util.Collections;

public class PointMainMin {
   public static void main(String[] args) {
	  ArrayList<Point> pointsList = new ArrayList<Point>();
	  
      // create Point objects (x,y)
      Point p1 = new Point(7, 2);
      Point p2 = new Point(4, 3);
      Point p3 = new Point(1, 8);
      Point p4 = new Point(5, 3);
      pointsList.add(p1);
      pointsList.add(p2);
      pointsList.add(p3);
      pointsList.add(p4);
      
      // print each point and its distance from the origin
      System.out.println("p1 is " + p1);
      System.out.printf("distance from origin = %3.2f\n",
                            p1.distanceFromOrigin());
   
      System.out.println("p2 is " + p2);
      System.out.printf("distance from origin = %3.2f\n",
                            p2.distanceFromOrigin());
      
      //compare points
      if(p1.compareTo(p2)==1) {
    	  System.out.println("p1 is bigger");
      }else if (p1.compareTo(p2)==-1) {
    	  System.out.println("p2 is bigger");
      }else {
    	  System.out.println("p1 and p2 are equal");
      }
      
      //sort the pointsList
      Collections.sort(pointsList);
      //loop the pointsList and print the result
      for(Point p : pointsList) {
    	  System.out.println(p);
      }
      
   }
}
