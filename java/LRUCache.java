import java.util.HashMap;

public class LRUCache {

    class Node{
        int key;
        int value;
        Node prev;
        Node next;
    }

    HashMap<Integer,Node> map= new  HashMap<>();
    int capacity=50;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head=new Node();
        tail= new Node();

        head.prev=null;
        head.next=tail;
        tail.next=null;
        tail.prev=head;
    }

    public int get(int key) {
        Node tempNode=map.get(key);
        if(tempNode!=null){
            moveToTail(tempNode);
            return tempNode.value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node tempNode=map.get(key);
            tempNode.value=value;
            moveToTail(tempNode);
        }else{
            Node temp= new Node();
            temp.key=key;
            temp.value=value;
            map.put(key,temp);
            addNode(temp);
            if(map.size()>capacity){
                int res=popHeadNext();
                map.remove(res);
            }
        }
    }

    public int popHeadNext(){
        Node temp = head.next;
        int key=temp.key;
        removeNode(temp);
        return key;
    }

    public void moveToTail(Node node){
        removeNode(node);
        addNode(node);
    }

    public void removeNode(Node node){
        Node prev= node.prev;
        Node next= node.next;
        prev.next=next;
        next.prev=prev;
        node.prev=null;
        node.next=null;
    }

    public void addNode(Node node){
        Node tailPrev= tail.prev;
        tailPrev.next=node;
        node.next=tail;
        tail.prev=node;
        node.prev=tailPrev;
    }
}
