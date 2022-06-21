package lesson.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Mr He
 */
public class BufferReaderDemo {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("D:\\Study\\Java\\springboot\\src\\main\\resources\\file\\c.txt"));
            bufferedWriter = new BufferedWriter(new FileWriter("D:\\Study\\Java\\springboot\\src\\main\\resources\\file\\d.txt"));

 /*           //读取22个字符
            char[] text = new char[22];
            bufferedReader.read(text);
            System.out.println(text);*/

            char[] chars = new char[1024];
            int len;
            while ((len = bufferedReader.read(chars)) != -1) {
                bufferedWriter.write(chars, 0, len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
