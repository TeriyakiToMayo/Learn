import java.util.Arrays;

public class Num31_NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] nums = {
				{},
				{1},
				{1, 2},
				{1, 2, 3},
				{3, 2, 1},
				{1, 1, 5},
				{1, 2, 3, 5, 4, 6},
		};
		
		
		for(int i = 0; i < nums.length; i++) {
			nextPermutation(nums[i]);
			System.out.println(Arrays.toString(nums[i]));
		}
		
		
		/*
		int[] a = {1, 2, 3, 4, 5};
		swap(a, 0, 1);
		System.out.println(Arrays.toString(a));
		reverse(a, 2);
		System.out.println(Arrays.toString(a));
		*/
		
	}
	
	public static void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 1) return;
        boolean hasNext = false;
        
        for(int i = nums.length - 1; i >= 1; i--) {
        	if(nums[i - 1] < nums[i]) {
        		hasNext = true;
        		for(int j = nums.length - 1; j >= i; j--) {
        			if(nums[i - 1] < nums[j]) {
        				swap(nums, i - 1, j);
        				//reverse
        				reverse(nums, i);
        				break;
        			}
        		}
        		break;
        	}
        }
        
        if(!hasNext) {
        	reverse(nums, 0);
        }
        
    }
	
	public static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
	
	public static void reverse(int[] nums, int start) {
		int i = start;
		int j = nums.length - 1;
		while(i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}

}
