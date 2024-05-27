import java.util.Random;

public class TextGenerator implements Runnable {
    private String letters;
    private int length;

    public TextGenerator(String letters, int length) {
        this.letters = letters;
        this.length = length;
    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }

    @Override
    public void run() {
        for (int i = 0; i < TextAnalyzer.NUMBER_OF_TEXTS; i++) {
            String text = generateText(letters, length);
            try {
                TextAnalyzer.queueA.put(text);
                TextAnalyzer.queueB.put(text);
                TextAnalyzer.queueC.put(text);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}