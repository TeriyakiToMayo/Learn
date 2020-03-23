
public class Num6_ZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "PAYPALISHIRING";
		String res = convert(str, 3);
		System.out.println(res);

	}
	
	public static String convert(String s, int numRows) {
		if(numRows <= 1) return s;
		StringBuilder[] sb = new StringBuilder[numRows];
		for(int i = 0; i <sb.length; i++) {
			sb[i] = new StringBuilder("");
		}
		for(int i = 0; i < s.length(); i++) {
			//calculate row
			int index = i % (numRows * 2 - 2);
			index = index < numRows ? index : (numRows * 2 - 2) - index;
			
			//insert character into StringBuilder
			sb[index].append(s.charAt(i));
		}
		
		String res = "";
		for(int i = 0; i < sb.length; i++) {
			res += sb[i];
		}
		
		return res;
	}
	
	
}
