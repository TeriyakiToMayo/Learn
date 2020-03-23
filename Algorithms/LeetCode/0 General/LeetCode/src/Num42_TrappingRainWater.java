import java.util.Stack;

public class Num42_TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] heights = {
				{0},
				{1},
				{1, 2},
				{0, 1, 0, 2},
				{2, 1, 0, 2},
				{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1},
		};
		
		for(int i = 0; i < heights.length; i++) {
			out2("" + trap2(heights[i]));
		}

	}

	public static int trap(int[] height) {
		
		int max = 0;
		for(int i = 0; i < height.length; i++) {
			max = height[i] > max ? height[i] : max;
		}
//		out("max = " + max);
//		out("");
		
		int water = 0;
		for(int l = 1; l <= max; l++) {
//			out("level = " + l);
			for(int i = 0; i < height.length;) {
				if(height[i] < l) {
					i++;
					continue;
				}
//				out("i = " + i);
				int next = nextBar(height, l, i);
//				out("next = " + next);
				if(next == -1) break;
				water += (next - i - 1);
//				out("water = " + water);
				i = next;
			}
//			out("");
		}
		
		return water;
    }
	
	public static int nextBar(int[] height, int level, int init) {
		for(int i = init + 1; i < height.length; i++) {
			if(height[i] >= level) return i;
		}
		return -1;
	}
	
	public static int trap2(int[] height) {
		if(height == null || height.length == 0) return 0;
		
		//Stack contains index of height
		Stack<Integer> stack = new Stack<Integer>();
		
		int water = 0;
		
		for(int i = 0; i < height.length; i++) {
			
			//Since we need to keep a declining stack, 
			//when current height is larger than top, then we believe there might be a pound
			if(!stack.isEmpty() && height[i] > height[stack.peek()]) {
				
				while(true) {
					//After poping the top, we see the left bound (new top)
					int curTop = stack.pop();
					
					//Case 1: no left bound
					//not possible to contain water
					if(stack.isEmpty()) {
						stack.push(i);
						break;
					}
					
					//Case 2: current height larger than left bound
					//we calculate the water in the current pound bounded by:
					//left bound, water bottom (last top), and current height
					int curTopH = height[curTop];
					int peekH = height[stack.peek()];
					if(peekH < height[i]) {
						water += (peekH - curTopH) * (i - stack.peek() - 1);
					}
					
					//Case 3: current height smaller than left bound
					//we calculate the water pound similar to case 2, 
					//then we see current height as next bottom
					if(peekH >= height[i]) {
						water += (height[i] - curTopH) * (i - stack.peek() - 1);
						stack.push(i);
						break;
					}
				}
			}else {
				//If current height keeps stack declining, then we push it
				stack.push(i);
			}
		}
		
		return water;
	}
	
	
	public static void out(String str) {
	//	 System.out.println(str);
	}
	
	public static void out2(String str) {
		 System.out.println(str);
	}
	
}


