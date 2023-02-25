import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res= new LinkedList<>();

        if(intervals==null)
            return (new int[0][0]);

        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        for(int[] interval:intervals){
            if(res.isEmpty() || interval[1]>res.getLast()[0]){
                res.add(interval);
            }else{
                res.getLast()[1]=Math.max(interval[1],res.getLast()[1]);
            }
        }
        return  res.toArray(new int[res.size()][]);
    }
}
