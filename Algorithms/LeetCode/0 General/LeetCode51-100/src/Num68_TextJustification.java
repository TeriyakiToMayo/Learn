import java.util.LinkedList;
import java.util.List;

public class Num68_TextJustification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[][] wordses = {
				/*
				{"a"},

				{"a", "b", "c", "d", "aaaaaaaaaaaaa", "a", "b", "c", "d"},

				{"This", "is", "an", "example", "of", "text", "justification."},
				{"What","must","be","acknowledgment","shall","be"},

				{"Science","is","what","we","understand","well","enough","to","explain",
			         "to","a","computer.","Art","is","everything","else","we","do"},
				*/
				
				{"My","momma","always","said,","\"Life","was","like","a","box","of",
			        	 "chocolates.","You","never","know","what","you're","gonna","get."
},
		};
		
		int[] maxes = {
			/*
			1,
			14,	
			16,
			16,
			20
			*/
			20,
		};
		
		for(int i = 0; i < wordses.length; i++) {
			List<String> list = fullJustify2(wordses[i], maxes[i]);
			for(String str : list) {
				IO.outMain("\"" + str + "\"");
			}
			
			IO.outMain("");
		}
		
	}
	
	//=======================================================
	// Solution 2
	//=======================================================
	//Instead of iterate through each word, now we find one line in each loop
    //Then, the problem of the last line is resolved
    public static List<String> fullJustify2(String[] words, int maxWidth) {
    	
    	int start = 0;
    	List<String> list = new LinkedList<String>();
    	
    	while(start < words.length) {
    		int[] result = findEnd(start, words, maxWidth);
    		list.add(generateLine2(words, start, result[0], result[1], maxWidth));
    		start = result[0] + 1;
    	}
    	
    	return list;
    }
    
    public static int[] findEnd(int start, String[] words, int maxWidth) {
    	int end = start;
    	int sum = words[end].length();
    	end++;
    	
    	while(end < words.length && (sum + 1 + words[end].length()) <= maxWidth) {
    		sum += 1 + words[end].length();
    		end++;
    	}
    	
    	return new int[] {end - 1, sum};
    }
    
    public static String generateLine2(String[] words, int start, int end, int curLen, int maxWidth) {
    	
    	int remainSpaces = maxWidth - curLen;
    	if(start == end)  return padResult(words[start], maxWidth);
    	
    	boolean lastLine = end == words.length - 1;
    	
    	int gaps = end - start;
    	remainSpaces += gaps;
    	String space = lastLine ? " " : generateSpaces(remainSpaces/gaps);
    	int remainder = lastLine ? 0 : remainSpaces%gaps;
    	
    	
    	StringBuilder sb = new StringBuilder();
    	sb.append(words[start]);
    	for(int i = start + 1; i <= end; i++) {
    		sb.append(space).append((remainder > 0 ? " " : "")).append(words[i]);
    		remainder--;
    	}
    	
    	return padResult(sb.toString(), maxWidth);
    }
    
    public static String padResult(String str, int maxWidth) {
    	StringBuilder sb = new StringBuilder();
    	sb.append(str).append(generateSpaces(maxWidth - str.length()));
    	return sb.toString();
    }
    
    public static String generateSpaces(int n) {
    	return new String(new char[n]).replace('\0', ' ');
    }
	
    //=======================================================
  	// Solution 1
  	//=======================================================
	//Iterate through each word, find each line
	//Problem: difficult to deal with the last line
    public static List<String> fullJustify(String[] words, int maxWidth) {
        
    	int curStart = 0;
    	int curLen = words[0].length();
    	List<String> list = new LinkedList<String>();
    	if(words.length == 1) {
    		list.add(generateLine(words, curStart, curStart, curLen, maxWidth, true));
    		return list;
    	}
    	
    	for(int i = 1; i < words.length; i++) {
    		int newLen = curLen + words[i].length() + 1;
    		if(newLen <= maxWidth) {
    			curLen = newLen;
    		}else {
    			list.add(generateLine(words, curStart, i - 1, curLen, maxWidth, false));
    			curStart = i;
    			curLen = words[i].length();
    		}
    		
    		
    		if(i == words.length - 1) {
    			list.add(generateLine(words, curStart, i, curLen, maxWidth, true));
    		}
    	}
    	
    	return list;
    }
    
    
    
    public static String generateLine(String[] words, int start, int end, int curLen, int maxWidth, boolean lastLine) {

    	String line = "";
    	int remainSpaces = maxWidth - curLen;
    	if(lastLine) {
    		line = words[start];
    		for(int i = start + 1; i <= end; i++) {
    			line += " " + words[i];
    		}
    		line += generateSpaces(remainSpaces);
    		return line;
    	}
    	
    	if(start == end)  return words[start] + generateSpaces(remainSpaces);
    	else if(start + 1 == end) return words[start] + generateSpaces(remainSpaces + 1) + words[end];
    	
    	int gaps = end - start;
    	
    	remainSpaces += gaps;
    	int range = remainSpaces/gaps;
    	String space = generateSpaces(range);
    	int spill = remainSpaces%gaps + start;
    	
    	line += words[start];
    	for(int i = start + 1; i <= end; i++) {
    		if(i <= spill) line += space + " " + words[i];
    		else line += space + words[i];
    	}
    	
    	return line;
    }
    
    
    
}
