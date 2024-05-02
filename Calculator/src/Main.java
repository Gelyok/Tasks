public class Main {
    public static void main(String[] args) {
        Ints calc = new IntsCalculator();

        System.out.println(calc.sum(2, 2));
        System.out.println(calc.sum(10, 22));
        System.out.println(calc.pow(2, 10));

        Calculator calculator = new Calculator();
        Calculator.Formula formula = calculator.new Formula();
        double result = formula.addOperand(5)
                .addOperand(15)
                .calculate(Calculator.Operation.MULT)
                .result();
        System.out.println(result);
    }
}