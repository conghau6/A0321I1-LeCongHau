package _16_io_text_file.bai_tap.optional_tong_cac_so_trong_file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("./src/_16_io_text_file/bai_tap/optional_tong_cac_so_trong_file/MyFile.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int result = 0;
            String line;
            while ((line = bufferedReader.readLine())!= null) {
                result += Integer.parseInt(line);
            }
            System.out.println("Tổng các số trong file: " + result);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
