import java.io.*;
import java.lang.*;
import java.util.*;

public class StudentCompare{

    public int maxEvents(int[][] events) {
        //Arrays.sort(events,(a,b)-> Integer.compare(a[0],b[0]));
        TreeSet<Integer> set = new TreeSet();

        for(int i=1;i<=100000;i++)
            set.add(i);
        //Fill the set with all the numbers from 1 to 100000(Max time limit for the events)
        int count=0;
        Arrays.sort(events,(a,b)-> a[1]-b[1]==0 ? a[0]-b[0] : a[1]-b[1]);
        //Sort the array based on end time
        for(int i=0;i<events.length;i++){
            //As the array is sorted know e can follow a greedy approach and fill the start time if found
            if(set.contains(events[i][0])){
                set.remove(events[i][0]);
                count++;
            }
            else{
                //If not find the just next higher element for the current event and
                //check whether it lies in the range of start to end time
                Integer high = set.higher(events[i][0]);
                if(high!=null && high<=events[i][1]){
                    count++;//Increment the count
                    set.remove(high); // Remove it from the set
                }
            }
        }
        return count;

    }

    public void exec(){
        int[][] arr=  {{1,2},{2,3},{3,4},{1,2}};
        maxEvents(arr);
    }
}
