package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

public class CSV {

    public static List<String[]> read(String file) {
        List<String[]> data = new LinkedList<>();
        String dataRow;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            while ((dataRow = br.readLine()) != null) {
                String[] dataRecords = dataRow.split(",");
                data.add(dataRecords);
            }

            br.close();

        } catch (Exception e) {
            System.out.println("_____EXCEPTION_IN_CSV_____");
            e.printStackTrace();
        }
        return data;
    }
}