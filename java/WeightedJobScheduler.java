import java.util.Arrays;

public class WeightedJobScheduler {

    public  int REQUEST_LIMIT=100;
    public long TIME_LIMIT=1000L;

    class Job{
        int start;
        int end;
        int profit;
        Job(int s, int e, int p){
            start=s;
            end=e;
            profit=p;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime,int[] profit){
        Job[] arr= new Job[startTime.length];
        for(int i=0;i<arr.length;i++){
            arr[i]=new Job(startTime[i],endTime[i],profit[i]);
        }
        Arrays.sort(arr,(a,b) -> a.start -b.start);
        int[] dp= new int[arr.length];
        Arrays.fill(dp,-1);


        return 0;
    }

    int rec(Job[] arr, int idx, int[] dp){
        if(idx== arr.length)
            return 0;
        if(dp[idx]!=-1)
            return dp[idx];
        int i=idx+1;
        while(i< arr.length && arr[i].start < arr[idx].end){
            i++;
        }
        return dp[idx]=Math.max(arr[idx].profit+rec(arr,i,dp),rec(arr,idx+1,dp));
    }
    
}
