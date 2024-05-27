import java.util.concurrent.BlockingQueue;

public class CharCounter implements Runnable {
    private BlockingQueue<String> queue;
    private char character;
    private int maxCount = 0;
    private String maxText = "";

    public CharCounter(BlockingQueue<String> queue, char character) {
        this.queue = queue;
        this.character = character;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String text = queue.take();
                int count = 0;
                for (char c : text.toCharArray()) {
                    if (c == character) {
                        count++;
                    }
                }
                if (count > maxCount) {
                    maxCount = count;
                    maxText = text;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public int getMaxCount() {
        return maxCount;
    }

    public String getMaxText() {
        return maxText;
    }
}