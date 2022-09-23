import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {
    Queue<Integer> hits;


    public HitCounter(){
        hits= new LinkedList<>();
    }

    public void hit(int timestamp){
        hits.add(timestamp);
    }

    public int getHits(int timeStamp){
        while(hits.size()>0 && hits.peek()<=timeStamp-3000){
            hits.poll();
        }
        return hits.size();
    }
}
