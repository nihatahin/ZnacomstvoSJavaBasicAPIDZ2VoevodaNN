package task4;

import java.util.Scanner;
import java.io.IOException;
import java.util.logging.*;



public class task {
    public static void main(String[] args) throws SecurityException, IOException {
        Logger logger = Logger.getLogger(task.class.getName());
        FileHandler fh = new FileHandler("./task4/log.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        Scanner scanner = new Scanner(System.in);

        System.out.printf("Enter first operand (double type number): ");
        double num1 = enter_num(scanner, logger);
        logger.info(Double.toString(num1) + " was entered as first operand.");
        System.out.printf("Enter second operand (double type number): ");
        double num2 = enter_num(scanner, logger);
        logger.info(Double.toString(num2) + " was entered as second operand.");
        System.out.printf("Enter operator (+, -, * or /): ");
        char oper = enter_oper(scanner, logger);
        logger.info(String.valueOf(oper) + " was entered as operator.");
        
        scanner.close();

        String res = Double.toString(num1) + " " + String.valueOf(oper) + " " + Double.toString(num2) + " = " + Double.toString(operation(num1, num2, oper));
        System.out.println(res);
        logger.info(Double.toString(operation(num1, num2, oper)) + " was calculated.");
    }

    public static double operation(double n1, double n2, char o) {
        switch(o)
        {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
            case '/':
                return n1 / n2;
        }
        return 0.0;
    }

    public static boolean validation(String str_n, Logger logger) {
        try{
            Double.parseDouble(str_n);
            return true;    
        }
        catch (NumberFormatException ex){
            System.out.printf("Invalid value was entered! Try again: ");
            logger.warning("Invalid value was entered!");
            return false;
        }
    }
    
    public static double enter_num(Scanner iScanner, Logger iLogger) {
        String str_num = "";
        boolean is_valid = false;
        while(!is_valid)
        {
            str_num = iScanner.nextLine();
            is_valid = validation(str_num, iLogger);

        }
        return Double.parseDouble(str_num);
    }


    public static boolean validation_ch(String str_n, Logger logger) {
        switch(str_n)
        {
            case "+":
            case "-":
            case "*":
            case "/":
                return true;
            default:
                System.out.printf("Invalid operator was entered! Try again: ");
                logger.warning("Invalid operator was entered!");
                return false;
        }
    }

    public static char enter_oper(Scanner iScanner, Logger iLogger) {
        
        String str_num = "";
        boolean is_valid = false;
        while(!is_valid)
        {
            str_num = iScanner.nextLine();
            is_valid = validation_ch(str_num, iLogger);
        }
        
        return str_num.toCharArray()[0];
    }


}
