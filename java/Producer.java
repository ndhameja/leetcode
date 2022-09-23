public class Producer extends Thread {

    StringBuffer buffer;
    boolean dp = false;

    Producer() {
        buffer = new StringBuffer();
    }

    public void run() {
        synchronized (buffer) {
            for (int i = 0; i < 4; i++) {
                try {
                    buffer.append(i);
                    System.out.println("Produced " + i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
