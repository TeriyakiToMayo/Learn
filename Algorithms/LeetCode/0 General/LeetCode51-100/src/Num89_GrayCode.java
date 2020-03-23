import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num89_GrayCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IO.outMain("" + grayCode3(3));
	}
	
	//=======================================================
	// Solution 3
	//=======================================================
	public static List<Integer> grayCode3(int n) {
		List<Integer> output = new ArrayList<>();
		output.add(0);
		if(n == 0) return output;
		
		for(int i = 0; i < n; i++) {
			int size = output.size();
			int add = 1 << i;
			for(int j = size - 1; j >= 0; j--) {
				output.add(add + output.get(j));
			}
		}
		
		return output;
    }
	
	//=======================================================
	// Solution 2
	//=======================================================
	public static List<Integer> grayCode2(int n) {
		List<Integer> output = new ArrayList<>();
		output.add(0);
		if(n == 0) return output;
		if(n == 1) {output.add(1); return output;}
		
		output = grayCode2(n - 1);
		int add = (int) Math.pow(2, n - 1);
		
		List<Integer> output2 = new ArrayList<>();
		for(int i = output.size() - 1; i >= 0; i--) {
			output2.add(add + output.get(i));
		}
		output.addAll(output2);
		
		return output;
    }
	
	//=======================================================
	// Solution 1
	//=======================================================
	public static List<Integer> grayCode(int n) {
		List<Integer> output = new ArrayList<>();
		List<String> list = helper(n);
//		IO.outTest("" + list);
		for(int i = 0; i < list.size(); i++) 
			output.add(Integer.parseInt(list.get(i), 2));
		
		return output;
    }
	
	public static List<String> helper(int n){
		List<String> list = new ArrayList<>();
		
		if(n == 0) {list.add("0"); return list;}
		if(n == 1) {list.addAll(Arrays.asList("0", "1")); return list;}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("0");
		List<String> subList = helper(n - 1);
		for(int i = 0; i < subList.size(); i++) {
			sb.append(subList.get(i));
			list.add(sb.toString());
			sb.delete(1, sb.length());
		}
		sb.delete(0, 1);
		sb.append("1");
		for(int i = subList.size() - 1; i >= 0; i--) {
			sb.append(subList.get(i));
			list.add(sb.toString());
			sb.delete(1, sb.length());
		}
		
		return list;
	}

}
