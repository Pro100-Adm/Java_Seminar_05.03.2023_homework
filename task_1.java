import java.util.logging.*;
import java.util.Arrays;
import java.io.IOException;

/**
 Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
результат после каждой итерации (после перемещения числа) запишите в лог-файл.
 */
public class task_1 {

    public static void bubbleSort(int[] sortArr){
        Logger myLogger = Logger.getLogger(task_1.class.getName());
        FileHandler fh;
        try {   
            fh = new FileHandler("MyLogFile.log");  
            myLogger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();  
            fh.setFormatter(formatter);  
        } catch (SecurityException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        for (int i = 0; i < sortArr.length - 1; i++) {
            for(int j = 0; j < sortArr.length - i - 1; j++) {
                if(sortArr[j + 1] < sortArr[j]) {
                    int swap = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = swap;
                    myLogger.log(Level.INFO, Arrays.toString(sortArr));
                }
            }
        }
    }

    public static void main(String args[]) {
        int[] sortArr = {12, 6, 4, 1, 15, 10, 10};
        bubbleSort(sortArr);
        for(int i = 0; i < sortArr.length; i++){
            System.out.print(sortArr[i] + "\n");
        }
    }
}