import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Num56_MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][][] intervalses = {
				
				{
				},
				
				{
					{1, 3}, 
				},
				
				{
					{1, 4}, {2, 3}, 
				},
				
				{
					{1, 3}, {2, 6}, {8, 10}, {15, 18},
				},
				
				
				{
					{1, 4}, {4, 5},
				},
				
		};
		
		for(int[][] intervals : intervalses) {
			out2(Arrays.deepToString(merge(intervals)));
		}

	}
	
	public static int[][] merge(int[][] intervals) {
        
		List<int[]> list = new LinkedList<int[]>();
		if(intervals.length == 0) return list.toArray(new int[0][0]);
		
		//Sort time: O(NlogN)
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});
		
		int[] curInterv = {intervals[0][0], intervals[0][1]};
		
		for(int i = 1; i < intervals.length; i++) {
			if(intervals[i][0] <= curInterv[1]) {
				if(curInterv[1] < intervals[i][1])
					curInterv[1] = intervals[i][1];
			}else {
				list.add(curInterv);
				curInterv = new int[2];
				curInterv[0] = intervals[i][0]; 
				curInterv[1] = intervals[i][1]; 
			}
			
		}
		
		list.add(curInterv);
		
		return list.toArray(new int[0][0]);
    }
	
	public int[][] merge2(int[][] arr) {
        if(arr == null || arr.length<=1)
            return arr;
        List<int[]> list = new ArrayList<>();
        //Arrays.sort(arr,(a,b)->a[0]-b[0]);
        Arrays.sort(arr,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });
        int i=0;
        int n = arr.length;
        while(i<n){
            int left = arr[i][0];
            int right = arr[i][1];
            while(i<n-1 && right>=arr[i+1][0]){
                right = Math.max(right,arr[i+1][1]);
                i++;
            }
            list.add(new int[] {left,right});
            i++;
        }
        return list.toArray(new int[list.size()][2]);
    }
	
	public static void out(String str) {
		 System.out.println(str);
	}
		
	public static void out2(String str) {
		 System.out.println(str);
	}

}
