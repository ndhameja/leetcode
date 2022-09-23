import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class QueueRateLimiter {

    public int REQUEST_LIMIT = 100;
    public Long TIME_LIMIT = 1000L;
    public HashMap<String, HitCounter> clientTimeStampMap = new HashMap<>();

    public class HitCounter{
        public Queue<Long> queue;
        public HitCounter() {
            queue = new LinkedList<>();
        }
        public boolean hit(long timestamp) {
            /* when a timestamp hit, we should poll all the timestamp before TIME_LIMIT*/
            while (!queue.isEmpty() && queue.peek() - timestamp >= TIME_LIMIT) queue.poll();
            if (queue.size() < 500) {
                queue.add(timestamp); return true;
            }
            return false;
        }
    }

    public boolean isAllow(String clientId){
        long currTime = System.currentTimeMillis();
        if (!clientTimeStampMap.containsKey(clientId)) {
            HitCounter h = new HitCounter();
            h.hit(currTime); return true;
        } else {
            HitCounter h = clientTimeStampMap.get(clientId);
            return h.hit(currTime);
        }
    }
}
