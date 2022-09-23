public class stackUsingLinkList {

    private class Node {

        int data; // integer data
        Node node; // reference variable Node type
    }

    Node top;

    stackUsingLinkList() {
        this.top = null;
    }


    public void push(int x) {
        Node temp = new Node();
        if (temp == null) {
            return;
        }

        temp.data = x;
        temp.node = top;
        top = temp;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        if (!isEmpty()) {
            return top.data;
        } else {
            System.out.println("Stack is empty");
            return -1;
        }

    }

    public void pop() {
        if (top == null) {
            System.out.print("\nStack Underflow");
            return;
        }

        // update the top pointer to point to the next node
        top = (top).node;
    }
}
