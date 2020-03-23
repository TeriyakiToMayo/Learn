import java.util.ArrayList;
import java.util.List;

public class Num95_UniqueBinarySearchTrees2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<TreeNode> output = generateTrees(2);
		IO.outMain("output size = " + output.size());
		for(TreeNode head : output) {
			TreeNode.printTree(head, 0, true);
			IO.outMain("");
		}
	}
	
	public static List<TreeNode> output;
	public static int N = 0;
	public static int remainNodes = 0;
	
	public static List<TreeNode> generateTrees(int n) {
		output = new ArrayList<TreeNode>();
		N = n;
		
		if(n >= 1) output.addAll(helper(1, n));
		
		return output;
    }
	
	public static List<TreeNode> helper(int start, int end) {
		TreeNode node = new TreeNode(start);
		List<TreeNode> list = new ArrayList<TreeNode>();
		
		if(start == end) {
			list.add(node);
			return list;
		}
		
		for(int i = start; i <= end; i++) {
			
			List<TreeNode> leftList = null;
			if(i != start) {
				leftList = helper(start, i - 1);
			}
			List<TreeNode> rightList = null;
			if(i != end) {
				rightList = helper(i + 1, end);
			}
			
			if(i == start) {
				for(int j = 0; j < rightList.size(); j++) {
					node = new TreeNode(i);
					node.right = rightList.get(j);
					list.add(node);
				}
			}else if(i == end) {
				for(int j = 0; j < leftList.size(); j++) {
					node = new TreeNode(i);
					node.left = leftList.get(j);
					list.add(node);
				}
			}else {
				for(int j = 0; j < leftList.size(); j++) {
					for(int k = 0; k < rightList.size(); k++) {
						node = new TreeNode(i);
						node.left = leftList.get(j);
						node.right = rightList.get(k);
						list.add(node);
					}
				}
			}
		}
		
		return list;
	}

}
