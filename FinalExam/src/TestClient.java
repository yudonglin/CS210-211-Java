import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestClient {

	public static void main(String[] args) {
		/*System.out.print(sumTo(2));
		Integer n1=12;
		Integer n2=7;
		Integer n3=15;
		String s1 = "calcium";
		String s2 = "salt";
		String s3 = "antimony";
		System.out.println(n1.compareTo(n2));
		System.out.println(n3.compareTo(n1));
		System.out.println(n2.compareTo(n1));
		System.out.println(s1.compareTo(s2));
		System.out.println(s3.compareTo(s1));
		System.out.println(s2.compareTo(s2));
		
		List<String> test = new ArrayList<String>();
		test.add("sam");
		test.add("cathy");
		test.add("jennie");
		test.add("zachary");
		test.add("robert");
		
		//test.add(31);
		mystery(test);
		
		mapTemp.put("ball","blue");
		mapTemp.put("winkie","yellow");
		mapTemp.put("corn","yellow");
		mapTemp.put("grass","green");
		mapTemp.put("emerald","green");
		
		mapTemp.put("sheep","wool");
		mapTemp.put("house","brick");
		mapTemp.put("cast","plaster");
		mapTemp.put("wool","wool");
		mapTemp.put("pumpkin","peach");
		mapTemp.put("corn","apple");
		mapTemp.put("apple","apple");
		mapTemp.put("pie","fruit");
		mapTemp.put("peach","peach");
		Map<String, String> mapTemp = new TreeMap<String,String>();
		
		
		System.out.println(mapTemp.toString());
		
		mystery(mapTemp);
		//System.out.println(mapTemp.toString());
		
		Stack s = new Stack<Integer>();
		s.push(5);
		s.push(13);
		System.out. println(s.pop());
		System.out.println(s.peek());
		s.push(9);
		s.push(5);
		s.push(6);
		System.out.println(s.pop()) ;
		System.out.println(s.isEmpty());
		System.out.println(s.size());
		System.out.println(s.peek());
		s.push(8);
		System.out.println(s.pop()) ;
		System.out.println(s.pop()) ;
		System.out.println(s.peek());
		*/
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(71);
		q.add(-3);
		q.add(15);
		q.add(42);
		q.add(9);
		q.add(4);
		System.out.println(q.toString());
		mystery(q);
	}
	
	public static double sumTo(int n){
		if(n == 0){
		    return 0.0;
		}else if(n == 1){
		   return 1.0;
		}else if(n < 0){
		    throw new IllegalArgumentException("input cannot be less than 0: "+n);
		}else{
		    return sumTo(n-1)+1.0/n;
		}
	}
	
	public static void mystery(ArrayList<Integer> list) {
		for (int i = list.size()-1;i>=0;i--) {
			if(i%2==0) {
				list.add(list.get(i));
			}else {
				list.add(0,list.get(i));
			}
		}
		System.out.println(list.toString());
	}
	
	public static void mystery(List<String> list) {
		Set<String> result = new TreeSet<String>();
		for(String element : list) {
			if (element.compareTo(list.get(0))<0){
				result.add(element);
			}else {
				result.clear();
			}
		}
		System.out.println(result.toString());
	}
	
	public static void mystery(Map<String, String> m) {
		Set<String> s = new TreeSet<String>();
		for (String key : m.keySet()) {
			if (!m.get(key).equals(key)) {
				s.add(m.get(key));
			} else {
				System.out.println(s.remove(m.get(key)));
				
			}
		}
		System.out.println(s.toString());
	}
	public static void mystery (Queue<Integer> q) {
		Stack<Integer> s = new Stack<Integer>();
		int size = q.size ();
		for(int i=0;i<size;i++){
			int n = q.remove();
			if(n%2==0) {
				s.push(n) ;
			} else {
				q.add(n);
			}
		}
		System.out.println("q: "+ q.toString() + "s: "+ s.toString());
	}

}
