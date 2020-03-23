import java.util.Arrays;

public class Num88_MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][][] numses = {
				{
					{}, {},
				},	
				
				{
					{1}, {},
				},	
				
				{
					{0}, {1},
				},	
				
				{
					{1, 2, 3, 0, 0, 0}, {2, 5, 6},
				},	
				
				{
					{1, 2, 3, 0, 0, 0, 0, 0}, {2, 5, 6, 7, 8},
				},	
		};
		
		int[][] lens = {
				{0, 0},
				{1, 0},
				{0, 1},
				{3, 3},
				{3, 5},
		};
		
		for(int i = 0; i < numses.length; i++) {
			merge(numses[i][0], lens[i][0], numses[i][1], lens[i][1]);
			IO.outMain(Arrays.toString(numses[i][0]));
			IO.outMain("");
		}
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] nums1_copy = nums1.clone();
		
		int a = 0, b = 0, c = 0;
		int len1 = nums1.length;
		
		while(c < len1) {
			if(a >= m || b >= n) {
				nums1[c++] = a >= m ? nums2[b++] : nums1_copy[a++];
				continue;
			}
			nums1[c++] = nums1_copy[a] <= nums2[b] ? nums1_copy[a++] : nums2[b++];
		}
    }
}
