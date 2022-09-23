import java.util.*;

public class topKFrequentWords_two {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String word: words) {
            map.put(word, map.getOrDefault(word,0)+1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> map.get(a) == map.get(b) ? a.compareTo(b) : map.get(b) - map.get(a));

        for(String word: map.keySet()) {
            pq.offer(word);
        }


        List<String> result = new ArrayList<>();

        while(k>0) {
            result.add(pq.poll());
            k--;
        }

        return result;
    }
}
