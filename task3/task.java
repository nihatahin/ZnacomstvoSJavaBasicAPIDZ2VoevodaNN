package task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class task {

    public static void main(String[] args) throws IOException {
        //String json = "[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]";
        BufferedReader br = new BufferedReader(new FileReader("./task3/data.json"));
        String stroka = br.readLine();
        br.close();


        System.out.println(stroka);
        String[] recs = stroka.split("},");
        recs[0] = recs[0].substring(2, recs[0].length());
        int rec_num = recs.length;
        recs[rec_num - 1] = recs[rec_num - 1].substring(1, recs[rec_num - 1].length() - 2);

        for (int i = 1; i < rec_num - 1; ++i)
            recs[i] = recs[i].substring(1, recs[i].length());

        for (int i = 0; i < recs.length; ++i)
            System.out.println(rec_reb(recs[i]));








        /*for (int i = 0; i < recs.length; ++i)
            System.out.println(recs[i]);*/
        



        //System.out.println(stroka);
    }

    public static String rec_reb(String stro){
        String[] sub_recs = stro.split(",");
        for (int i = 0; i < sub_recs.length; ++i)
        {
            sub_recs[i] = sub_recs[i].split(":")[1];
            sub_recs[i] = sub_recs[i].substring(1, sub_recs[i].length() - 1);
        }

        StringBuilder fin = new StringBuilder("Студент ");
        fin.append(sub_recs[0]);
        fin.append(" получил ");
        fin.append(sub_recs[1]);
        fin.append(" по предмету ");
        fin.append(sub_recs[2]);
        fin.append(".");

        
        return fin.toString();
    }

}
