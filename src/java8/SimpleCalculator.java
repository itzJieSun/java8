package java8;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.function.BiFunction;

public class SimpleCalculator {
    public static void main(String[] args) {
        calculateNumbers();
    }


    private static void calculateNumbers() {
        System.out.println("Start, type exit to quit!");
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Number 1: ");
            String num1 = scanner.next();
            if (num1.trim().equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Operator: ");
            String operator = scanner.next();
            if (operator.trim().equalsIgnoreCase("exit")) {
                break;
            } else if (!operator.matches("[/ * + -]")) {
                System.out.println("No operators, please check and try again!");
                continue;
            }

            System.out.print("Number 2: ");
            String num2 = scanner.next();
            if (operator.trim().equalsIgnoreCase("exit")) {
                break;
            }

            BigDecimal n1 = new BigDecimal(num1);
            BigDecimal n2 = new BigDecimal(num2);

            Operation op = new Operation();
            switch (operator){
                case "+":
                    System.out.println("Result: " + op.add(n1,n2));
                    break;
                case "-":
                    System.out.println("Result: " + op.sub(n1,n2));
                    break;
                case "*":
                    System.out.println("Result: " + op.multiply(n1,n2));
                    break;
                default:
                    if (n2.equals(new BigDecimal("0"))){
                        System.out.println("No, cannot use 0 as the dividend");
                        break;
                    }
                    System.out.println("Result: " + op.divide(n1,n2));
                    break;
            }
        }
    }

}

class Operation{
    public BigDecimal add(BigDecimal n1, BigDecimal n2){
        BiFunction<BigDecimal, BigDecimal, BigDecimal> addOp = (num1, num2) -> num1.add(num2);
        return addOp.apply(n1,n2);
    }
    public BigDecimal sub(BigDecimal n1, BigDecimal n2){
        BiFunction<BigDecimal, BigDecimal, BigDecimal> addOp = (num1, num2) -> num1.subtract(num2);
        return addOp.apply(n1,n2);
    }
    public BigDecimal multiply(BigDecimal n1, BigDecimal n2){
        BiFunction<BigDecimal, BigDecimal, BigDecimal> addOp = (num1, num2) -> num1.multiply(num2);
        return addOp.apply(n1,n2);
    }
    public BigDecimal divide(BigDecimal n1, BigDecimal n2){
        BiFunction<BigDecimal, BigDecimal, BigDecimal> addOp = (num1, num2) -> num1.divide(num2);
        return addOp.apply(n1,n2);
    }

}