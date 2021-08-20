package _16_io_text_file.bai_tap.copy_file;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("./src/_16_io_text_file/bai_tap/copy_file/Source.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("./src/_16_io_text_file/bai_tap/copy_file/Target.txt",false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String result = "";
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                result += line + '\n';
            }
            result = result.substring(0, result.length() - 1);
            bufferedWriter.write(result);
            bufferedReader.close();
            fileReader.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
