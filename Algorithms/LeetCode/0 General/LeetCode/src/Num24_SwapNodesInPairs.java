
public class Num24_SwapNodesInPairs {
	
	public static class ListNode {
	     int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	 }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] nums = {
				{}, 
				{1}, 
				{1, 2}, 
				{1, 2, 3}, 
				{1, 2, 3, 4}, 
				{1, 2, 3, 4, 5},
		};
		
		ListNode[] heads = new ListNode[nums.length];
		
		for(int i = 0; i < nums.length; i++) {
			heads[i] = generateListNode(nums[i]);
		}
		
		for(int i = 0; i < nums.length; i++) {
			/*
			ListNode[] result = reverseListNodes(2, heads[i]);
			System.out.println("result[0] = " + result[0].val + " result[1] = " + result[1].val);
			printListNodes(result[1]);
			*/
			
			
		//	ListNode result = swapPairs(heads[i]);
			ListNode result = reverseKGroup(heads[i], 1);
			System.out.println("result:");
			printListNodes(result);
			System.out.println();
			
		}
		
	}
	
	public static ListNode swapPairs(ListNode head) {
        
		return reverseKGroup(head, 2);
    }
	
	public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
		
        ListNode result = null;
        boolean reversed = false;
        
		int count = 1;
		ListNode pointer = head;
		ListNode temp = new ListNode(0);
		ListNode lastSectionEnd = null;
		ListNode nextSectionOpen = null;
		
		while(pointer != null) {
			if(count == 1) {
				temp = pointer;
				pointer = pointer.next;
				count++;
			}
			else if(count == k) {
				reversed = true;
				nextSectionOpen = pointer.next;
				ListNode[] reverse = reverseListNodes(k, temp);
				
			//	System.out.println("current reversed nodes");
			//	printListNodes(reverse[1]);
				
				if(result == null) {
					result = reverse[1];
				}
				
				//Connect reversed head
				if(lastSectionEnd != null) {
					lastSectionEnd.next = reverse[1];
				}
				
				//Connect reversed tail
				reverse[0].next = nextSectionOpen;
				
				//Set lastSectionEnd
				lastSectionEnd = reverse[0];
				//Set next head
				pointer = nextSectionOpen;
				count = 1;
				
			}else {
				pointer = pointer.next;
				count++;
			}
		}
		
		return reversed ? result : head;
    }
	
	public static ListNode[] reverseListNodes(int num, ListNode head) {
		ListNode[] nodes = new ListNode[2];
		
		ListNode lastNode = head;
		ListNode curNode = head.next;
		ListNode nextNode = curNode.next;
		for(int i = 1; i < num; i++) {
			curNode.next = lastNode;
			lastNode = curNode;
			curNode = nextNode;
			if(nextNode != null) nextNode = nextNode.next;
		}
		
		head.next = null;
		nodes[0] = head;
		nodes[1] = lastNode;
		
		return nodes;
	}
	
	public static ListNode generateListNode(int[] nums) {
		if(nums.length == 0) return null;
		ListNode head = new ListNode(nums[0]);
		ListNode curNode = head;
		
		for(int i = 1; i < nums.length; i++) {
			
			ListNode newNode = new ListNode(nums[i]);
			curNode.next = newNode;
			curNode = newNode;
		}
		
		return head;
	}
	
	public static void printListNodes(ListNode head) {
		if(head == null) {
			System.out.println("empty list");
			return;
		};
		ListNode curNode = head;
//		System.out.println();
		System.out.print(curNode.val);
		curNode = curNode.next;
		while(curNode != null) {
			System.out.print("->" + curNode.val);
			curNode = curNode.next;
		}
		System.out.println();
	}
}
