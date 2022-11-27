package task1;

/*import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;*/

public class task {

    public static void main(String[] args) {
        String query_mask = "SELECT *\nFROM Students\nWHERE ";
        String params[] = {"name", "country", "city", "age"};
        String answer[] = {"Ivanov", "Russia", "Moscow", "null"};
        //query.append("asdaas");
    
        for (int i = 0; i < params.length; ++i)
        {
            if (answer[i].equals("null"))
                continue;
            else
            {
                StringBuilder query = new StringBuilder(query_mask);
                query.append(params[i]);
                query.append(" == ");
                query.append(answer[i]);
                query.append("\n");

                System.out.println(query);
            }
        }


        

        

    }
}
