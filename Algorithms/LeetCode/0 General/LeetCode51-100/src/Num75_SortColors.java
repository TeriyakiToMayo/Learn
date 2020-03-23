import java.util.Arrays;

public class Num75_SortColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] numses = {
				{2,0,2,1,1,0},	
		};
		
		for(int[] nums : numses) {
			sortColors(nums);
			IO.outMain(Arrays.toString(nums));
			IO.outMain("");
		}
	}
	
    public static void sortColors(int[] nums) {
    	quickSort(nums, 0, nums.length - 1);
    }
    
    public static void quickSort(int[] nums, int a, int b) {
    	if(a >= b) return;
    	int mid = nums[a];
    	int start = a, end = b, midPos = a;
    	a += 1;
    	
    	int dir = 0;
    	while(a <= b) {
    		if((dir == 0 && mid > nums[b]) || (dir == 1 && mid < nums[a])) {
    			int swapPos = dir == 0 ? b : a;
    			swap(nums, midPos, swapPos);
    			midPos = swapPos;
    			a += dir == 1 ? 1 : 0;
        		b += dir == 0 ? -1 : 0;
        		dir = dir == 0 ? 1 : 0;
        		continue;
    		}
    		a += dir == 1 ? 1 : 0;
    		b += dir == 0 ? -1 : 0;
    	}
    	
    	quickSort(nums, start, midPos - 1);
    	quickSort(nums, midPos + 1, end);
    }
    
    public static void swap(int[] nums, int a, int b) {
    	nums[a] = nums[a] ^ nums[b];
    	nums[b] = nums[a] ^ nums[b];
    	nums[a] = nums[a] ^ nums[b];
    }

}
