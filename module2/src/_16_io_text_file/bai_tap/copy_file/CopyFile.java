package _16_io_text_file.bai_tap.copy_file;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
        String result = "";
        try {
            FileReader fileReader = new FileReader("./src/_16_io_text_file/bai_tap/copy_file/Source.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) result += line;
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fileWriter = new FileWriter("./src/_16_io_text_file/bai_tap/copy_file/Target.txt",false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(result);
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
