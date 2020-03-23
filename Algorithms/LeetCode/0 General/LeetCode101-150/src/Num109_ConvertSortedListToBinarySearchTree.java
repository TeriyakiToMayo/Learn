import java.util.Arrays;

import Utils.IO;
import Utils.ListNode;
import Utils.TreeNode;

public class Num109_ConvertSortedListToBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] numses = {
				{},
				{1},
				{1, 2},
				{1, 2, 3},
				{-10, -3, 0, 5, 9},
		};
		
		ListNode[] heads = new ListNode[numses.length];
		for(int i = 0; i < numses.length; i++) {
			IO.outMain(Arrays.toString(numses[i]));
			heads[i] = ListNode.generateListNode(numses[i]);
			TreeNode root = sortedListToBST(heads[i]);
			TreeNode.printTree(root, 0, true);
			IO.outMain("");
		}
		
	}
	
	public static ListNode newHead;
	
	public static TreeNode sortedListToBST(ListNode head) {
		if(head == null) return null;
		
		int len = 0;
		ListNode pointer = head;
		while(pointer != null) {
			len++;
			pointer = pointer.next;
		}
		newHead = head;
		
		return helper(0, len - 1);
    }
	
	public static TreeNode helper(int start, int end) {
		int mid = (start + end)/2;
		TreeNode node = new TreeNode(0);
		if(start < mid) node.left = helper(start, mid - 1);
		node.val = newHead.val;
		newHead = newHead.next;
		if(mid < end) node.right = helper(mid + 1, end);
		
		return node;
	}
	
	

}
