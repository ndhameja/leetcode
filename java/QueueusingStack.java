import java.util.*;


public class QueueusingStack {
    Stack<Integer> stack1= new Stack<>();
    Stack<Integer> stack2= new Stack<>();

    public void enQueue(int x){
        stack1.push(x);

    }

    public int deQueue(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();

    }
}
