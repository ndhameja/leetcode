import java.util.Arrays;
import java.util.TreeMap;

public class WeightedJobSchedulerTreeMap {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {

            Integer start = jobs[i][0];
            Integer prev = map.floorKey(start);
            if (prev == null) {
                ans = Math.max(ans, jobs[i][2]);
            } else {
                int preSum = map.get(prev);
                ans = Math.max(ans, preSum + jobs[i][2]);
            }

        }
        return ans;
    }

    public void test(){

        int [] startTime = new int[]{1,2,3,3};
        int [] endTime = new int[]{2,4,5,6};
        int [] profit = new int[]{50,10,40,70};

       int maxprofit= jobScheduling(startTime,endTime,profit);
       System.out.println(maxprofit);
    }
}
