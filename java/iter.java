//import java.io.PrintWriter;
//import java.io.StringWriter;
//import java.lang.reflect.Method;
//import java.lang.reflect.Modifier;
//import java.util.*;
//import java.util.stream.Collectors;
//
//interface MultiMap<K,V> extends Iterable<Map.Entry<K,V>> {
//
//    /**
//     * Adds a value to either existing key or creates a new key and adds the value to it if the key value pair does not already exist
//     * @param  key     key to add value to
//     * @param  value   value to add
//     * @return         <code>true</code> if the underlying collection has changed; <code>false</code> otherwise
//     */
//    boolean add(K key, V value);
//
//    /**
//     * Returns a sequence of values for the given key. throws Exception if the key is not present
//     * @param    key     key to retrieve the sequence of values for
//     * @return           sequence of values for the given key
//     */
//    Iterable<V> get(K key) throws Exception;
//
//    /**
//     * Returns a sequence of values for the given key. returns empty sequence if the key is not present
//     * @param    key     key to retrieve the sequence of values for
//     * @return           sequence of values for the given key
//     */
//    Iterable<V> getOrDefault(K key);
//
//    /**
//     * Removes the value from the values associated with the given key. throws Exception if the key is not present
//     * @param    key     key which values need to be adjusted
//     * @param    value   value to remove from the values for the given key
//     */
//    void remove(K key, V value) throws Exception;
//
//    /**
//     * Removes the given key from the dictionary with all the values associated with it
//     * @param    key     key to remove from the dictionary
//     */
//    void clear(K key);
//
//    /**
//     * Returns a sequence of pairs that represent the MultiValueDictionary collection
//     * <pre>
//     * MultiMap<String, String> creatures = new MultiMapImpl<String, String>();
//     * creatures.add("birds", "eagle");
//     * creatures.add("birds", "dove");
//     * creatures.add("animals", "tiger");
//     *
//     * for (Map.Entry<String, String> creature : creatures.flatten()) {
//     *     System.out.println("- {" + creature.Key + ", " + creature.Value" +"}");
//     * }
//     *
//     * This will print 3 pairs:
//     * - {birds, eagle}
//     * - {birds, dove}
//     * - {animals, tiger}
//     *
//     * </pre>
//     */
//    Iterable<Map.Entry<K,V>> flatten();
//}
//
//class MultiMapImpl<K,V> implements MultiMap<K, V> {
//
//    // Add your code here
//
//    Map<K,Collection<V>> map =  new HashMap<>();
//
//    public boolean add(K key, V value){
//
//        if (map.get(key) == null) {
//            map.put(key, new ArrayList<>());
//        }
//
//        // if the value is absent, insert it
//        if (!map.get(key).contains(value)) {
//            map.get(key).add(value);
//        }
//    }
//
//    public Iterable<V> get(K key) throws Exception{
//        //return map.get(key).asList();
//        return map.get(key).values().stream()
//                .collect(Collectors.toList());
//    }
//
//    public Iterable<V> getOrDefault(K key){
//        return map.getOrDefault(key,null);
//
//    }
//
//
//    public void remove(K key, V value) throws Exception{
//        List<V> lstr= new ArrayList<>();
//        lstr=getOrDefault(key);
//
//        lstr.remove(value);
//        map.get(key).put(lstr);
//
//    }
//
//    public void clear(K key){
//        map.remove(key);
//    }
//
//
//    public Iterable<Map.Entry<K,V>> flatten(){
//
//
//        //for (map.keySet<K, V> creature : map.flatten()) {
//        //System.out.println("- {" + creature.Key + ", " + creature.Value" "+"}");
//        //}
//
//        //Iterable<Map.Entry<K,V>> itr = new Iterable<Map.Entry<K,V>>();
//        return null;
//
//
//    }
//
//    @Override
//    public Iterator<Map.Entry<K, V>> iterator() {
//        return null;
//    }
//}