import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test_Ground {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list = Arrays.asList(1, 2, 3);
		out("" + list.contains(1));		//output: true
		
		Set<Integer> set = new HashSet<>(list);
		
		List<Integer> list2 = new LinkedList<>(Arrays.asList(1, 2, 3));
		Integer[] arr = list2.toArray(new Integer[0]);
		
		List<String> myList = new LinkedList<String>();
		myList.add("Apple");
		myList.add("Banana");
		myList.add("Orange");
		String[] myArray = myList.toArray(new String[0]);
		
	}
	
	public static void out(String str) {
		 System.out.println(str);
	 }

}
