/**
 Реализовать простой калькулятор (+ - / *) с логированием
 */
import java.util.Scanner;
import java.util.logging.*;
import java.io.IOException;

 public class task_3 {

    public static void main(String[] args) {
        calc();
    }

    public static void calc(){

        Logger myLogger = Logger.getLogger(task_1.class.getName());
        FileHandler fh;
        try {   
            fh = new FileHandler("CalcLogFile.log");  
            myLogger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();  
            fh.setFormatter(formatter);  
        } catch (SecurityException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  

        char operator = operatorUserInput();
        int operand_1 = operandUserInput();
        int operand_2 = operandUserInput2();
        myLogger.log(Level.INFO, "operator is " + operator);
        myLogger.log(Level.INFO, "operand 1 is " + Integer.toString(operand_1));
        myLogger.log(Level.INFO, "operand 2 is " + Integer.toString(operand_2));
        if (operator=='+') {
            System.out.print(operand_1+operand_2);
            myLogger.log(Level.INFO, "result is " + Integer.toString(operand_1+operand_2));
        }
        if (operator=='-') {
            System.out.print(operand_1-operand_2);
            myLogger.log(Level.INFO, "result is " + Integer.toString(operand_1-operand_2));
        }
        if (operator=='*') {
            System.out.print(operand_1*operand_2);
            myLogger.log(Level.INFO, "result is " + Integer.toString(operand_1*operand_2));
        }
        if (operator=='/'){
            try {
                System.out.print((float) operand_1/operand_2);
                myLogger.log(Level.INFO, "result is " + Float.toString(operand_1/operand_2));                
            } catch (Exception e) {
                System.out.println("Division error!");
                myLogger.log(Level.WARNING, "Division error!");  
                calc();
            }
        }
    }

    public static int operandUserInput(){
        Scanner operandInput = new Scanner(System.in);
        System.out.print("Enter operand: ");
        String operand = operandInput.nextLine();
        try {
            int number = Integer.parseInt(operand);
            return number;
        } catch (Exception e) {
            System.out.println("Wrong operand!");
            return operandUserInput();
        } 
    }
    
    public static char operatorUserInput(){
        Scanner operatorInput = new Scanner(System.in);
        System.out.print("Enter operator: ");
        char operator = operatorInput.nextLine().charAt(0);
        try {
            if(operator=='+' | operator=='-' | operator=='*' | operator=='/'){
                return operator;
            }
            else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println(" Wrong operator!");
            return operatorUserInput();
        }
    }

    public static int operandUserInput2(){
        Scanner operandInput = new Scanner(System.in);
        System.out.print("Enter operand: ");
        String operand = operandInput.nextLine();
        try {
            int number = Integer.parseInt(operand);
            return number;
        } catch (Exception e) {
            System.out.println("Wrong operand!");
            return operandUserInput();
        } finally {
            operandInput.close();
        } 
    }    
}
