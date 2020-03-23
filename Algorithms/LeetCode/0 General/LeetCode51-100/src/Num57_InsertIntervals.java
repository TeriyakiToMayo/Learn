import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Num57_InsertIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][][] intervalses = {
				{},
				{{1, 3}},
				{{1, 3}, {6, 9}},
				{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
		};
		
		int[][] newIntervals = {
				{1, 2},
				{0, 10},
				{5, 10},
				{4, 8},
		};
		
		for(int i = 0; i < intervalses.length; i++) {
			IO.print2DArray(insert(intervalses[i], newIntervals[i]), true);
			IO.outMain("");
		}

	}
	
	public static int[][] insert(int[][] intervals, int[] newInterval) {
		
		if(intervals.length == 0) return new int[][] {newInterval};
		
		Comparator<int[]> comparator = new Comparator<int[]>(){
			@Override
			public int compare(int[] a, int[] b){
				return a[0] - b[0];
			}
		};
		
		Arrays.sort(intervals, comparator);
		
		int left = -1;
		int right = -1;
		for(int i = 0; i < intervals.length; i++) {
			left = left == -1 ? findPos(newInterval[0], i, intervals[i]) :  left;
			right = right == -1 ? findPos(newInterval[1], i, intervals[i]) : right;
			
			if(right >= 0) break;
		}
		
		if(left == -1) left = 2 * intervals.length;
		if(right == -1) right = 2 * intervals.length;

		if(left == right) {
			List<int[]> list = new LinkedList<int[]>(Arrays.asList(intervals));
			if(left%2 == 0) {
				list.add(left/2, newInterval);
			}
			return list.toArray(new int[0][0]);
		}else {
			List<int[]> list = new LinkedList<int[]>();
			for(int i = 0, start = left/2; i < intervals.length; i++) {
				if(i == start) {
					int leftBound = left%2 == 0 ? newInterval[0] : intervals[i][0];
					int rightBound = right%2 == 0 ? newInterval[1] : intervals[right/2][1];
					list.add(new int[] {leftBound, rightBound});
					i = right%2 == 0 ? right/2 - 1 : right/2;
				}else list.add(intervals[i]);
			}
			return list.toArray(new int[0][0]);
		}
		
    }
	
	public static int findPos(int bound, int i, int[] interval) {
		if(bound < interval[0]) {
			return 2 * i; 
		}else if(interval[0] <= bound && bound <= interval[1]) {
			return 2 * i + 1;
		}
		return -1;
	}

}
