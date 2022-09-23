import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals56 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a, b)-> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        int[] newInterval = intervals[0];
        res.add(newInterval);

        for (int[] interval : intervals) {
            if(interval[0] <= newInterval[1]){ // overlapping
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
            else{
                newInterval = interval;
                res.add(newInterval);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
