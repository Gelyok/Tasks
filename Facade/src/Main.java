public class Main {
    public static void main(String[] args) {
        BinOps bins = new BinOps();

        String sumResult = bins.sum("101", "11");
        System.out.println("Сумма: " + sumResult);
        
        String multResult = bins.mult("101", "11");
        System.out.println("Произведение: " + multResult);
    }
}