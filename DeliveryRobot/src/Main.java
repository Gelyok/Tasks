import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        int numRoutes = 1000;
        int routeLength = 100;
        String letters = "RLRFR";

        ExecutorService executorService = Executors.newFixedThreadPool(numRoutes);
        List<String> routes = new ArrayList<>();

        for (int i = 0; i < numRoutes; i++) {
            routes.add(RouteGenerator.generateRoute(letters, routeLength));
        }

        for (String route : routes) {
            executorService.submit(new RouteAnalyzer(route));
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        printResults(RouteAnalyzer.sizeToFreq);
    }

    private static void printResults(Map<Integer, Integer> sizeToFreq) {
        int maxFrequency = 0;
        int mostFrequentSize = 0;

        for (Map.Entry<Integer, Integer> entry : sizeToFreq.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mostFrequentSize = entry.getKey();
            }
        }

        System.out.println("Самое частое количество повторений " + mostFrequentSize + " (встретилось " + maxFrequency + " раз)");
        System.out.println("Другие размеры:");
        for (Map.Entry<Integer, Integer> entry : sizeToFreq.entrySet()) {
            if (entry.getKey() != mostFrequentSize) {
                System.out.println("- " + entry.getKey() + " (" + entry.getValue() + " раз)");
            }
        }
    }
}