
public class Num28_ImplementstrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a = "";
		String b = "b";
		
		System.out.println(strStr(a, b));

	}
	
	public static int strStr(String haystack, String needle) {
        if(haystack == null || needle == null) return -1;
		
		if(haystack.length() < needle.length()) return -1;
		else if(needle.length() == 0) return 0;
		
		System.out.println("okay");
		
		String temp = haystack;
		int index = 0;
		while(temp.length() >= needle.length()) {
			boolean contains = true;
			for(int i = 0; i < needle.length(); i++) {
				if(temp.charAt(i) != needle.charAt(i)) {
					contains = false;
					break;
				}
			}
			if(contains) return index;
			
			index++;
			temp = temp.substring(1);
		}
		
		
		return -1;
    }

}
