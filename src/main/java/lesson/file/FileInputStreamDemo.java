package lesson.file;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Mr He
 */
@Slf4j
public class FileInputStreamDemo {


    public static void main(String[] args) {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //根据数据源创建字节输入流对象
            fileInputStream = new FileInputStream("D:\\Study\\Java\\springboot\\src\\main\\resources\\file\\a.txt");
            //根据目的地创建字节流输出对象
            fileOutputStream = new FileOutputStream("D:\\Study\\Java\\springboot\\src\\main\\resources\\file\\b.txt");
            int by;
            //read()从输入流中读取一个字节的数据。如果没有可用的输入，此方法将阻塞。
            //返回:数据的下一个字节，如果到达文件末尾，则为-1。
            while ((by = fileInputStream.read()) != -1) {
                fileOutputStream.write(by);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    log.error(e.getMessage());
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    log.error(e.getMessage());
                }
            }

        }

    }
}
