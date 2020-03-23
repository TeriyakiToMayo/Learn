import java.util.ArrayList;
import java.util.List;

public class Num2_AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][][] nums = {
				{{2, 4, 3}, {5, 6, 4}},
				{{2, 4, 3}, {5, 6}},
				{{0}, {0}},
				{{0}, {1}},
				{{0}, {1, 2}},
				{{1, 2}, {0}},
				{{1}, {2}},
				{{9}, {8}},
				{{5}, {5}},
		};
		
		for(int i = 0; i < nums.length; i++) {
			ListNode l1 = ListNode.generateListNode(nums[i][0]);
			ListNode l2 = ListNode.generateListNode(nums[i][1]);
			ListNode.printListNodes(addTwoNumbers2(l1, l2));
		}

	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> a = num(l1);
        List<Integer> b = num(l2);
        
        List<Integer> c = addArrayList(a, b);
        return GenerateListNode(c);
    }
    
    public static List<Integer> addArrayList(List<Integer> a, List<Integer> b){
        if(a.size() > b.size()){
            List<Integer> c = a;
            a = b;
            b = c;
        }
        
        List<Integer> result = new ArrayList<>();
        boolean offset = false;
        for(int i = 0; i < b.size(); i++){
            int tempResult = 0;
            if(i < a.size()){
                tempResult = a.get(i) + b.get(i);
            }else{
                tempResult = b.get(i);
            }
            if(offset){
                tempResult += 1;
            }
            if(tempResult < 10){
                offset = false;
            }else{
                offset = true;
            }
            result.add(tempResult%10);
        }
        if(offset){
            result.add(1);
        }
        
        return result;
    }
    
    public static List<Integer> num(ListNode list){
        List<Integer> arrayList = new ArrayList<>();
        ListNode currentList = list;
        while(currentList != null){
            arrayList.add(currentList.val);
            currentList = currentList.next;
        }
        
        return arrayList;
    }
    
    public static ListNode GenerateListNode(List<Integer> c){
        ListNode newListNode = new ListNode(c.get(0));
        ListNode currentListNode = newListNode;
        for(int i = 1; i < c.size(); i++){
            currentListNode.next = new ListNode(c.get(i));
            currentListNode = currentListNode.next;
        }
        
        return newListNode;
    }
    
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    	
    	ListNode l3 = new ListNode(0);
    	ListNode head = l3;
    	int carry = 0;
    	boolean first = true;
    	while(l1 != null || l2 != null || carry != 0) {
    		if(first) first = false;
    		else {
        		l3.next = new ListNode(0);
        		l3 = l3.next;
    		}
    		
    		int digit = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
    		
    		if(digit > 9) {
    			carry = 1;
    			digit -= 10;
    		}else carry = 0;
    		
    		l3.val = digit;
    		
    		if(l1 != null) l1 = l1.next;
    		if(l2 != null) l2 = l2.next;
    		
    	}
    	
    	return head;
    }

}
