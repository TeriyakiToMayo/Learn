
public class Num11_ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {1,8,6,2,5,4,8,3,7};
		int result = maxArea2(height);
		System.out.println(result);
	}
	
	public static int maxArea(int[] height) {
        
		int maxResult = 0;
		
		for(int i = 0; i < height.length - 1; i++) {
			for(int j = i + 1; j < height.length; j++) {
				int a = height[i];
				int b = height[j];
				int water = (a > b ? b : a) * (j - i);
				maxResult = water > maxResult ? water : maxResult;
			}
		}
		
		return maxResult;
    }
	
	public static int maxArea2(int[] height) {
		
		int l = 0, r = height.length - 1;
		int maxA = 0, curA = 0;;
		
		while(l != r) {
			if(height[l] <= height[r]) {
				curA = height[l] * (r - l);
				l += 1;
			}else {
				curA = height[r] * (r - l);
				r -= 1;
			}
			maxA = (maxA > curA) ? maxA : curA;
		}
		
		return maxA;
	}
	
}
