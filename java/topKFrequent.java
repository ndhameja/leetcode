import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class topKFrequent {

    class Pair implements Comparable<Pair>{
        String str;
        int freq;

        public Pair(String str, int freq) {
            this.str = str;
            this.freq = freq;
        }

        public int compareTo(Pair other) {
            if(other.freq == this.freq) {
                return this.str.compareToIgnoreCase(other.str);
            }
            return other.freq - this.freq;
        }
    }

    public List<String> topKFrequentWords(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(String word : map.keySet()) {
            pq.add(new Pair(word, map.get(word)));
        }

        List<String> list = new ArrayList<>();
        int temp = k;
        while(temp > 0) {
            Pair rem = pq.remove();
            list.add(rem.str);
            temp -= 1;
        }

        return list;
    }
}
