import java.util.ArrayList;
import java.util.List;

public class Num19_RemoveNthNodeFromEndOfList {

	public static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] nums = {
				{1, 2, 3, 4, 5},
		//		{0, 0, 0},
		};
		
		ListNode[] heads = new ListNode[nums.length];
		
		for(int i = 0; i < nums.length; i++) {
			heads[i] = generateListNode(nums[i]);
			printListNodes(heads[i]);
		}
		
		int[] locations = {
				2,
		};
		
		for(int i = 0; i < heads.length; i++) {
			printListNodes(removeNthFromEnd2(heads[i], locations[i]));
		}
		
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null) return null;
        List<ListNode> list = new ArrayList<>();
        
        ListNode curNode = head;
        while(curNode != null) {
        	list.add(curNode);
        	curNode = curNode.next;
        }
        
  //      System.out.println(list.get(0).val);
        int index = list.size() - n;
  //      System.out.println("index = " + index + " list.size() = " + list.size() + " n = " + n);
        if(index == 0) return head.next;
        else {
  //      	System.out.println("index " + (index - 1) + " = " + list.get(index - 1).val);
        	list.get(index - 1).next = list.get(index).next;
        }
		
		return head;
    }
	
	public static ListNode generateListNode(int[] nums) {
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
	
	public static ListNode removeNthFromEnd2(ListNode head, int n) {
	    
	    ListNode start = new ListNode(0);
	    ListNode slow = start, fast = start;
	    slow.next = head;
	    
	    //Move fast in front so that the gap between slow and fast becomes n
	    for(int i=1; i<=n+1; i++)   {
	        fast = fast.next;
	    }
	    //Move fast to the end, maintaining the gap
	    while(fast != null) {
	        slow = slow.next;
	        fast = fast.next;
	    }
	    //Skip the desired node
	    slow.next = slow.next.next;
	    return start.next;
	}
	
}
