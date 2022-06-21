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

            char[] chars = new char[1024];
            int len;
            //read(char cbuf[]) 将字符读入数组。此方法将阻塞，直到有输入可用、发生I/O错误或到达流的末端。
            //参数:cbuf -目标缓冲区
            //返回:读取的字符数，如果到达流的末尾，则为-1
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
