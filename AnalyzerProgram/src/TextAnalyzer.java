import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TextAnalyzer {
    public static final int QUEUE_CAPACITY = 100;
    public static final int NUMBER_OF_TEXTS = 10000;
    public static final int TEXT_LENGTH = 100000;

    public static BlockingQueue<String> queueA = new ArrayBlockingQueue<>(QUEUE_CAPACITY);
    public static BlockingQueue<String> queueB = new ArrayBlockingQueue<>(QUEUE_CAPACITY);
    public static BlockingQueue<String> queueC = new ArrayBlockingQueue<>(QUEUE_CAPACITY);
}