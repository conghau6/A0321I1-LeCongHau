package _16_io_text_file.bai_tap.optional_doc_file_csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DocFileCsv {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("./src/_16_io_text_file/bai_tap/optional_doc_file_csv/Country.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            List<Country> countryList = new ArrayList<>();
            while ((line = bufferedReader.readLine())!= null){
                String[] cou = line.split(",");
                countryList.add(new Country(cou[0],cou[1],cou[2],cou[3],cou[4],cou[5]));
            }

            for (Country country: countryList) {
                System.out.println(country);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
