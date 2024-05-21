import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RouteAnalyzer implements Runnable {
    private final String route;
    public static final Map<Integer, Integer> sizeToFreq = new ConcurrentHashMap<>();

    public RouteAnalyzer(String route) {
        this.route = route;
    }

    @Override
    public void run() {
        int rCount = 0;
        for (char c : route.toCharArray()) {
            if (c == 'R') {
                rCount++;
            }
        }

        synchronized (sizeToFreq) {
            sizeToFreq.put(rCount, sizeToFreq.getOrDefault(rCount, 0) + 1);
        }
    }
}