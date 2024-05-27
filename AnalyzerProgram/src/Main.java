public class Main {
    public static void main(String[] args) {
        Thread generatorThread = new Thread(new TextGenerator("abc", TextAnalyzer.TEXT_LENGTH));
        CharCounter counterA = new CharCounter(TextAnalyzer.queueA, 'a');
        CharCounter counterB = new CharCounter(TextAnalyzer.queueB, 'b');
        CharCounter counterC = new CharCounter(TextAnalyzer.queueC, 'c');

        Thread counterThreadA = new Thread(counterA);
        Thread counterThreadB = new Thread(counterB);
        Thread counterThreadC = new Thread(counterC);

        generatorThread.start();
        counterThreadA.start();
        counterThreadB.start();
        counterThreadC.start();

        try {
            generatorThread.join();
            counterThreadA.interrupt();
            counterThreadB.interrupt();
            counterThreadC.interrupt();
            counterThreadA.join();
            counterThreadB.join();
            counterThreadC.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Максимальное количество 'a': " + counterA.getMaxCount());
        System.out.println("Текст: " + counterA.getMaxText().substring(0, 100) + "...");

        System.out.println("Максимальное количество 'b': " + counterB.getMaxCount());
        System.out.println("Текст: " + counterB.getMaxText().substring(0, 100) + "...");

        System.out.println("Максимальное количество 'c': " + counterC.getMaxCount());
        System.out.println("Текст: " + counterC.getMaxText().substring(0, 100) + "...");
    }
}