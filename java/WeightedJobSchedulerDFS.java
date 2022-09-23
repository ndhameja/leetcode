import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WeightedJobSchedulerDFS {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        Map<Integer, Integer> memo = new HashMap();
        return dfs(jobs, 0, memo);
    }
    private int dfs( int[][] jobs, int index, Map<Integer, Integer> memo) {
        int n = jobs.length;
        if (n == index)   return 0;
        if(memo.containsKey(index))
            return memo.get(index);

        for(int next=index+1; next<n;next++){
            if(jobs[next][0]>=jobs[index][1]){
                int include = jobs[index][2] + dfs(jobs, next, memo);
                int exclude = dfs(jobs, index + 1, memo);
                int max =Math.max(include,exclude);
                memo.put(index,max);
                return max;
            }
        }
        int include = jobs[index][2];
        int exclude =dfs(jobs, index+1,memo);
        int max= Math.max(include,exclude);
        memo.put(index,max);
        return max;
    }

    public void test(){

        int [] startTime = new int[]{1,2,3,3};
        int [] endTime = new int[]{2,4,5,6};
        int [] profit = new int[]{50,10,40,70};

        int maxprofit= jobScheduling(startTime,endTime,profit);
        System.out.println(maxprofit);
    }

}
