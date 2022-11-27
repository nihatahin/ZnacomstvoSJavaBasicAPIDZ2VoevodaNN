package task2;

import java.io.IOException;
import java.util.logging.*;

public class task {
    
    public static void main(String[] args) throws SecurityException, IOException {
        Logger logger = Logger.getLogger(task.class.getName());
        ConsoleHandler ch = new ConsoleHandler();
        logger.addHandler(ch);
        FileHandler fh = new FileHandler("./task2/log.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        ch.setFormatter(sFormat);
        fh.setFormatter(sFormat);

        int length_arr = 10;
        int array[] = new int[length_arr];
        for (int i = 0; i < length_arr; ++i)
            array[i] = (int)(Math.random()*20 - 10);

        print_arr(array);

        for (int i = 0; i < length_arr; i++)
        {
            for (int j = 0; j < length_arr - 1; j++)
            {
                if (array[j] > array[j + 1])
                {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    logger.info(print_arr(array));
                }
            }
        }
        
    }

    public static String print_arr(int array[]) {
        StringBuilder out_arr = new StringBuilder("[");
        for (int i = 0; i < array.length; ++i)
        {
            out_arr.append(array[i]);
            out_arr.append(" ");
            
        }
        
        out_arr.delete(out_arr.length() - 1, out_arr.length());
        out_arr.append("]");
        return out_arr.toString();
        //System.out.println(out_arr);
    }

}
