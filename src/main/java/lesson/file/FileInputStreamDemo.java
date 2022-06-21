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
