import java.util.Arrays;

import Utils.IO;
import Utils.TreeNode;

public class Num108_ConvertSortedArrayToBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] numses = {
				/*
				{},
				{1},
				{1, 2},
				{1, 2, 3},
				{-10, -3, 0, 5, 9},	
				*/
				{-10,-3,0,5,9},
		};
		
		for(int[] nums : numses) {
			IO.outMain(Arrays.toString(nums));
			TreeNode head = sortedArrayToBST(nums);
			TreeNode.printTree(head, 0, true);
			IO.outMain("");
		}
		
	}
	
	public static TreeNode sortedArrayToBST(int[] nums) {
		if(nums.length == 0) return null;
		
		return helper(nums, 0, nums.length - 1);
    }
	
	public static TreeNode helper(int[] nums, int start, int end) {
		int mid = (start + end)/2;
		
		TreeNode node = new TreeNode(nums[mid]);
		
		if(mid > start) node.left = helper(nums, start, mid - 1);
		if(mid < end) node.right = helper(nums, mid + 1, end);
		return node;
	}

}
