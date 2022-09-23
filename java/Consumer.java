public class Consumer extends Thread{
    Producer p;
    Consumer(Producer temp){
        p=temp;
    }

    public void run(){
        synchronized (p.buffer){
            try{
                p.buffer.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < 4; i++) {
                System.out.print(p.buffer.charAt(i) + " ");
            }
            System.out.println("\nBuffer is Empty");
        }

    }
}
