
public class Num4_MedianOfTwoSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("okay");
		
		int[] nums1 = {2};
		int[] nums2 = {};
		double result = findMedianSortedArrays(nums1, nums2);
		
		System.out.println("result = " + result);
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
	    if(nums1.length > nums2.length) {
	    	return findMedianSortedArrays(nums2, nums1);
	    }
	    
	    int len = nums1.length + nums2.length;
	    int cut1 = 0;
	    int cut2 = 0;
	    int cutL = 0;
	    int cutR = nums1.length;
	    while(true) {	// not necessarily "cut1 <= nums1.length", since when cut1 == nums1.length, cutL == cutR == nums1.length, cut1 cannot move anywhere 
	    	cut1 = (cutR - cutL)/2 + cutL;
	    	cut2 = len/2 - cut1;
	    	double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];					//Here, the code can naturally process arrays with 0 or 1 items
	    	double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];				//In case of 0 item:      (L1) MIN | MAX (R1)
	    	double R1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];     //In case of 1 item:      (L1) MIN | 1 (R1) | MAX
	    	double R2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];
	    	
	    	if(L1 > R2) {
	    		cutR = cut1 - 1;
	    	}else if(L2 > R1) {
	    		cutL = cut1 + 1;
	    	}else {
	    		if(len % 2 == 0) {
	    			L1 = L1 > L2 ? L1 : L2;
	    			R1 = R1 < R2 ? R1 : R2;
	    			return (L1 + R1) / 2;
	    		}else {
	    			R1 = (R1 < R2) ? R1 : R2;
	    			return R1;
	    		}
	    	}
	    }
	    
	}
	
}
